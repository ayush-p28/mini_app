package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import models.User;

@WebServlet("/khilona.do")
public class KhilonaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        
        if(user!=null) 
            request.getRequestDispatcher("khilona.jsp").forward(request, response);
    }
}