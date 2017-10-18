/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.service;

import dear.shop.model.UserLogin;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class UserService {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @PersistenceContext
    private EntityManager em;
    
    public Boolean validasi(String user, String pass) {
        
        try {
            UserLogin us = (UserLogin) em.createNamedQuery("UserLogin.findByUserPass")
                               .setParameter("user", user)
                               .setParameter("pass", pass)
                               .getSingleResult();
            
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
    
}
