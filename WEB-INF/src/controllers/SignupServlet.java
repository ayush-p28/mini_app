package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import models.User;

@WebServlet("/register.do")
public class SignupServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Session
        HttpSession session = request.getSession();

        // forward page
        String nextPage = "signup.jsp";
        
        // parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer userType = Integer.parseInt(request.getParameter("type"));
        
        // validation
        boolean flag = true;

        Pattern p1 = Pattern.compile("[A-Za-z ]{2,35}");
        Matcher m1 = p1.matcher(name);

        if(!m1.matches()) {
            request.setAttribute("uname_err", "Incorrect User Name...!");
            flag = false;
        }

        Pattern p2 = Pattern.compile("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
        Matcher m2 = p2.matcher(email);

        if(!m2.matches()) {
            request.setAttribute("email_err", "Invalid Email...!");
            flag = false;
        }

        Pattern p3 = Pattern.compile("[A-Za-z0-9_]{6,12}");
        Matcher m3 = p3.matcher(password);

        if(!m3.matches()) {
            request.setAttribute("passw_err", "Invalid Password...!");
            flag = false;
        }
        
        // model
        if(flag) {
            User user = new User(name, email, password, userType);
            if(user.addUser())
                response.sendRedirect("login.do");
            else {
                request.setAttribute("message", "User exists with the same email...");            
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } 
        } else {
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }        
    }
}