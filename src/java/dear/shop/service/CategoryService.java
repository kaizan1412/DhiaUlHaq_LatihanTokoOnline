/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.service;

import dear.shop.model.Category;
import dear.shop.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class CategoryService {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Category> getAll(){
        List<Category> cat = em.createNamedQuery("Category.findAll").getResultList();
        return cat;
    }
    
    
}
