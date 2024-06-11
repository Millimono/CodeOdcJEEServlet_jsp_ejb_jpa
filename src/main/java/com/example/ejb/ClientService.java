/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.example.ejb;

import com.example.jpa.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public void createClient(Client client) {
        em.persist(client);
    }

    public Client findClient(Long id) {
        return em.find(Client.class, id);
    }

    public void updateClient(Client client) {
        em.merge(client);
    }

    public void deleteClient(Long id) {
        Client client = em.find(Client.class, id);
        if (client != null) {
            em.remove(client);
        }
    }
}

