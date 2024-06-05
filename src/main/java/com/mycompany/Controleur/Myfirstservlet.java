/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controleur;

import com.mycompany.firstappcore.Livre;
import com.mycompany.projet1.Tests.Voiture;
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
@WebServlet(name = "Myfirstservlet", urlPatterns = {"/Myfist"})
public class Myfirstservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException 
    {
        PrintWriter out = resp.getWriter();
        
        Personne p = new Personne("sory", "millimono");
        
        Voiture v = new Voiture("critoen","mod",2023);

         out.println
        (
                 "<html>"
                    +"<body>"
                    +       "<h1>Hello :"+p.toString()+"</h1>"
                    +       "<h1>Hello :"+v.afficherDetail()+"</h1>"

                    +"</body>"
                +"</html>"                
        );   
    }
   
}
