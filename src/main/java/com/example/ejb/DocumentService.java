/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.example.ejb;


import com.example.jpa.Document;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class DocumentService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public void createDocument(Document document) {
        em.persist(document);
    }

    public Document findDocument(Long id) {
        return em.find(Document.class, id);
    }

    public void updateDocument(Document document) {
        em.merge(document);
    }

    public void deleteDocument(Long id) {
        Document document = em.find(Document.class, id);
        if (document != null) {
            em.remove(document);
        }
    }
}

