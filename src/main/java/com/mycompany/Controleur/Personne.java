/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controleur;

/**
 *
 * @author Lenovo
 */
public class Personne {
    private String lastName;
    private String firstName;

    public Personne(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Personne{" + "lastName=" + lastName + ", firstName=" + firstName + '}';
    }
    
    

}
