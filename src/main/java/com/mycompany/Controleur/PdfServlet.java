/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controleur;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
@WebServlet(name = "PdfServlet", urlPatterns = {"/Pdf"})
public class PdfServlet extends HttpServlet {
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         response.setContentType("application/pdf");
         response.setHeader("Content-Disposition", "inline; filename=somme.pdf");

         Integer somme = (Integer)request.getAttribute("somme");
        
         String message;
         if (somme == null) {
             message = "hello toi";
         } else {
             message = "La somme est : " + String.valueOf(somme);
         }
        
        try{
            Document doc =new Document();
            PdfWriter.getInstance(doc, response.getOutputStream());
            doc.open();
            doc.add(
              new Paragraph(message)
            );
            doc.close();
            
        } catch (Exception e)
        {
            e.printStackTrace();
        } 
       
    }

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
               processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException 
    {
        processRequest(req, resp);
    }
    

}
