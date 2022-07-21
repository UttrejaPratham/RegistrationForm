package com.example.registrationform;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uemail = request.getParameter("username");
        String upass = request.getParameter("password");
        HttpSession session = request.getSession();

        RequestDispatcher dispatcher = null;
        if(uemail == null || uemail.equals(" ")){
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        if(upass == null || uemail.equals(" ")){
            request.setAttribute("status", "invalidPassword");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registeruser?useSSL=false", "root", "Prathamsql@07");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE uemail = ? and upass = ?");
            preparedStatement.setString(1, uemail);
            preparedStatement.setString(2, upass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                session.setAttribute("name", resultSet.getString("uname"));
                dispatcher = request.getRequestDispatcher("index.jsp");
            }else{
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
