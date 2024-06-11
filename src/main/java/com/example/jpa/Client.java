/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

/**
 *
 * @author Lenovo
 */
@Entity
public class Client extends Personne {
private String adresse;

@Transient
private String ageCategory;

// Getters et setters
public String getAdresse() 
 {

    return adresse;
 }

public void setAdresse(String adresse) 
{
    this.adresse = adresse;
}
}

