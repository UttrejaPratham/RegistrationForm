package com.example.registrationform;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upass = request.getParameter("pass");
        String repass = request.getParameter("re_pass");
        String umobile = request.getParameter("contact");
        RequestDispatcher dispatcher = null;

        Connection connection = null;

        if(uname == null || uname.equals(" ")){
            request.setAttribute("status", "invalidName");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }if(uemail == null || uemail.equals(" ")){
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }if(upass == null || upass.equals(" ")){
            request.setAttribute("status", "invalidPassword");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        } else if (!upass.equals(repass)) {
            request.setAttribute("status", "invalidConfirmPassword");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }
        if(umobile == null || umobile.equals(" ")){
            request.setAttribute("status", "invalidMobileNumber");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        } else if (umobile.length() > 10) {
            request.setAttribute("status", "invalidNumberlength");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registeruser?useSSL=false", "root", "Prathamsql@07");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(uname, upass, uemail, umobile) values (?,?,?,?)");

            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, upass);
            preparedStatement.setString(3, uemail);
            preparedStatement.setString(4, upass);

            int rowcount = preparedStatement.executeUpdate();
            dispatcher = request.getRequestDispatcher("registration.jsp");
            if(rowcount > 0){
                request.setAttribute("status", "success");
            }
            else{
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request,response);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
