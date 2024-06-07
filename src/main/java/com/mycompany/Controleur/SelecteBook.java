/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controleur;

import com.mycompany.projet1.Tests.Livre;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "SelecteBook", urlPatterns = { "/SelecteBook" })
public class SelecteBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);

        if ("selectBook".equals(action)) 
        {
            
            String selectedBook = request.getParameter("book");
            
            Livre livre = new Livre();
            livre.setNumLivre(selectedBook);
            session.setAttribute("Livre", livre);

            //session.setAttribute("selectedBook", selectedBook);
            
            response.sendRedirect("payBook.html");
            
        } else if ("payBook".equals(action)) 
        
        {
            Livre selectedBook = (Livre) session.getAttribute("Livre");
            String username = (String) session.getAttribute("username");

            if (selectedBook == null) {
                response.sendRedirect("selectBook.html");
                return;
            }
            
           // response.sendRedirect("BookServlet.jsp");
            
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/BookServlet.jsp");
            dispatcher.forward(request, response);


           /* response.setContentType("text/html");
            response.getWriter().append("<html><body>")
                    .append("User ").append(username)
                    .append(" has successfully paid for the book: " + selectedBook)
                    .append("</body></html>");*/

            session.removeAttribute("selectedBook");
            session.removeAttribute("username");
            session.invalidate();
        }

    }

}
