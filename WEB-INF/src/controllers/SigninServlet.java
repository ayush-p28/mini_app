package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import models.User;

@WebServlet("/login.do")
public class SigninServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password);
        if(user.loginUser()) {
            session.setAttribute("user", user);
            response.sendRedirect("khilona.do");
        } else {
            response.sendRedirect("login.do");
        }
    }
}