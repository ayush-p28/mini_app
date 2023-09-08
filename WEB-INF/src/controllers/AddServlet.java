package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import models.User;
import models.Khilona;

@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if(user != null){
            if(user.getUserType() == 1) 
                request.getRequestDispatcher("add_khilona.jsp").forward(request, response);
            else 
                request.getRequestDispatcher("chor.jsp").forward(request, response);
            } else {
                session.setAttribute("err_msg", "Sorry! your session is expired...!");        
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }            
        }
        
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            HttpSession session = request.getSession();
            
            User user = (User)session.getAttribute("user");
            
            if(user!=null) {
                if(user.getUserType() == 1) {
                    String name = request.getParameter("name");
                    int price = Integer.parseInt(request.getParameter("price"));
                    String ageGroup = request.getParameter("age_group");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    
                    Khilona khilona = new Khilona(name, price, ageGroup, quantity, user);
                    
                    if(khilona.addKhilona()) {
                        response.sendRedirect("khilona.do");
                    } else {
                        request.getRequestDispatcher("add.do").forward(request, response);
                    }            
                } else {
                    request.getRequestDispatcher("chor.jsp").forward(request, response);                    
                }
            } else {
            session.setAttribute("err_msg", "Sorry! your session is expired...!");
            response.sendRedirect("login.do");
        }        
    }
}
