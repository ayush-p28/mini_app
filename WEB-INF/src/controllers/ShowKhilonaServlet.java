package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import java.util.ArrayList;

import models.Khilona;
import models.User;

@WebServlet("/show.do")
public class ShowKhilonaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        //next page
        String nextPage = "login.do";

        //model
        if(user!=null) {
            ArrayList<Khilona> khilonas = null;
            if(user.getUserType() == 1) {                
                khilonas = Khilona.collectAllKhilonas(user.getUserId());
            } else {
                khilonas = Khilona.collectAllKhilonas();
            }

            request.setAttribute("all_khilonas", khilonas);
            //forward
            request.getRequestDispatcher("all_khilonas.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher(nextPage).forward(request, response);
        }
    }
}
