/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TypesPersonnels;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class EmployeeId implements Serializable {
private String departmentId;
private Long employeeNumber;
// Getters et setters

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}

