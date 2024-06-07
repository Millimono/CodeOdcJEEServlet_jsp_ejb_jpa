/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Somme", urlPatterns = {"/Somme"})
public class Somme extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out;
        
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String format = request.getParameter("format");

        
        //int somme = Integer.parseInt(nombre1)+ Integer.parseInt(nombre2);
        
         if (this.isInteger(nombre1) && this.isInteger(nombre2)) {
           int somme = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
            request.setAttribute("somme", somme);

             if (format != null && !format.isEmpty()) {
                // if ("pdf".equalsIgnoreCase(format)) {
                 //}
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/Pdf");
                 dispatcher.forward(request, response);

             } else {
                 RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/Somme.jsp");

                 dispatcher.forward(request, response);

                   
                 /*response.setContentType("text/html");

                 out = response.getWriter(); 

                 out.print("<html><body>La somme est " + somme + "</body></html>");
             */
             }

         } else 
         {
             RequestDispatcher dispatcher = request.getRequestDispatcher("/Error");
             dispatcher.forward(request, response);
         }   
        
    }
    
    

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        } 
        else 
        {

            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) 
            {
                return false;
            }
        }
    }

    

}
