/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.example.ejb;

import com.mycompany.projet1.Tests.Livre;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
@Stateless
@LocalBean
public class BookServiceBean 
{
    private static final Map<String, Livre> books = new HashMap<>();
    
        public Livre findBookById(String id) 
        {
        return books.get(id);
        }
        
    static {
        Livre book1 = new Livre();
        book1.setNumLivre("1");
        book1.setTitle("Book A");
        books.put("1", book1);
        
        Livre book2 = new Livre();
        book2.setNumLivre("2");
        book2.setTitle("Book B");        
        books.put("2", book2);

        Livre book3 = new Livre();
        book3.setNumLivre("3");
        book3.setTitle("Book C");
        books.put("3", book3);
    }




}
