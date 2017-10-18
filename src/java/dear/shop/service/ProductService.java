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
public class ProductService {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Product> getAll(){
        List<Product> product = em.createNamedQuery("Product.findAll").getResultList();
        
        return product;
    }
    
    public Product detailProduct(Long prodId){
        Product product = (Product) em.createNamedQuery("Product.findById")
                                      .setParameter("prodId", prodId)
                                      .getSingleResult();
        
        return product;
    }
    
    public List<Product> getByCategory(Integer id){
//        Category cat = (Category) em.createNamedQuery("Category.findById")
//                                  .setParameter("catId", id)
//                                  .getSingleResult();
        Category cat = em.find(Category.class, id);
/*        List<Product> product*/ return cat.getProduct();
  //      return product;
    }
}
