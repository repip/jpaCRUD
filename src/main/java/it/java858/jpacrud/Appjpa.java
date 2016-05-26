/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud;

import it.java858.jpacrud.entity.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class Appjpa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Customer cust = new Customer(null,"mario","rossi","12121213", "mario@mario.it","ivrea", "it",new Date());
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        
        
        
        List<Customer> resultlist = em.createQuery("select e from Customer e ORDER BY e.lastName", Customer.class).getResultList();

        for (Customer c : resultlist) {
            System.out.println(c);
        }
        em.close();
    }

}
