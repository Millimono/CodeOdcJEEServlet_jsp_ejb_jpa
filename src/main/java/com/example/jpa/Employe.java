/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa;

import com.example.TypesPersonnels.Address;
import com.example.TypesPersonnels.EmployeeId;
import com.example.TypesPersonnels.EmployeeType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Lenovo
 */
@Entity
@AttributeOverride(name = "email",
column = @Column(name = "employee_email", nullable = false, unique = true))
public class Employe extends Personne 
{
    @EmbeddedId
    private EmployeeId id;

    @Column(name = "departement_name", nullable = false, length = 50)
    private String departement;
    
    @Column(name = "employee_name", columnDefinition = "VARCHAR(50) NOT NULL")
    private String nom;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    private EmployeeType employeeType;

    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "street", column = @Column(name = "home_street")),
    @AttributeOverride(name = "city", column = @Column(name = "home_city")),
    @AttributeOverride(name = "state", column = @Column(name = "home_state")),
    @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code"))
    })
    private Address address;
    
    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;




    // Getters et setters
    public String getDepartement() 
    {
        return departement;

    }
    public void setDepartement(String departement) 
    {
        this.departement = departement;
    } 

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}

