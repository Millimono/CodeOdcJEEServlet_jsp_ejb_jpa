/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controleur;

import com.mycompany.ejb.HelloBean;
import jakarta.ejb.EJB;
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
@WebServlet(name="HelloServelet",urlPatterns={"/Hello"} )
public class HelloServlet extends HttpServlet
{
    @EJB
    private HelloBean Bean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        PrintWriter out = resp.getWriter();

         out.println
        (
                 "<html>"
                    +"<body>"
                    +       "<h1>Hello : Personne</h1>" 
                         +Bean.from()
                    +"</body>"
                +"</html>"                
        );        

        
    }


    
}
