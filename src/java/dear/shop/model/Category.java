/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT cat FROM Category cat"),
        @NamedQuery(name = "Category.findByName", query = "SELECT cat FROM Category cat where cat.categoryName = :namecat"),
        @NamedQuery(name = "Category.findById", query = "SELECT cat FROM Category cat where cat.id = :catId")
    })
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String categoryName;
    
    
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> product;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dear.shop.model.Category[ id=" + id + " ]";
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the product
     */
    public List<Product> getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(List<Product> product) {
        this.product = product;
    }
    
}
