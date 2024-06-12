/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
@Entity
public class Library {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "library_name", nullable = false)
    private String name;
    @ElementCollection
    @CollectionTable(name = "library_books", 
            joinColumns = @JoinColumn(name = "library_id"))
    @MapKeyColumn(name = "isbn")
    @Column(name = "book_info")
    private Map<String, BookInfo> books;
     // Getters et setters
}
