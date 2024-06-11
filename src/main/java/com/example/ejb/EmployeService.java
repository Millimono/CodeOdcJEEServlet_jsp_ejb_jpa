/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.example.ejb;

import com.example.TypesPersonnels.EmployeeId;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author Lenovo
 */

import com.example.jpa.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Stateless
public class EmployeService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public void createEmploye(Employe employe) {
        em.persist(employe);
    }

    public Employe findEmploye(EmployeeId id) {
        return em.find(Employe.class, id);
    }

    public void updateEmploye(Employe employe) {
        em.merge(employe);
    }

    public void deleteEmploye(EmployeeId id) {
        Employe employe = em.find(Employe.class, id);
        if (employe != null) {
            em.remove(employe);
        }
    }
    
    public List<Employe> findAllEmployes() {
        TypedQuery<Employe> query = em.createQuery
        ("SELECT e FROM Employe e", Employe.class);
        return query.getResultList();
    }
    
     /*public List<Employe> findAllEmployess() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employe> cq = cb.createQuery(Employe.class);
        Root<Employe> rootEntry = cq.from(Employe.class);
        CriteriaQuery<Employe> all = cq.select(rootEntry);

        return em.createQuery(all).getResultList();
    }*/
}

