/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.controller;

import dear.shop.model.Category;
import dear.shop.model.Product;
import dear.shop.service.CategoryService;
import dear.shop.service.ProductService;
import java.util.List;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService ps;
    @Autowired
    CategoryService cs;
    
    @RequestMapping()
    public String index(Model model, HttpSession sess){
        try {
            List<Product> p = ps.getAll();
            model.addAttribute("dataprod", p);
            model.addAttribute("msg", "Data ditemukan");
            return "product/v_product";
        } catch (NullPointerException e) {
            model.addAttribute("dataprod", "");
            model.addAttribute("msg", "Data tidak ditemukan");
            return "product/v_product";
        }
        
    }
    
    @RequestMapping("cate/{catid}")
    public String prodByCategory(@PathVariable Integer catid, HttpSession session, Model model){
        try {
            List<Product> p = ps.getByCategory(catid);
            model.addAttribute("dataprod", p);
            model.addAttribute("msg", "Data ditemukan");
            return "product/v_productpercategory";
        } catch (NullPointerException e) {
            model.addAttribute("dataprod", "");
            model.addAttribute("msg", "Data tidak ditemukan");
            return "product/v_productpercategory";
        }        
    }
        
    @RequestMapping("detail/{prodId}")
    public String detailProduct(@PathVariable Long prodId, Model model){
        try {
            Product product = ps.detailProduct(prodId);
            model.addAttribute("data", product);
            model.addAttribute("msg", "");
            return "product/v_productdetail";
        } catch (NoResultException e) {
            model.addAttribute("msg", "Tidak ada detail product yang dapat ditampilkan");
            model.addAttribute("data", "");
            return "product/v_productdetail";
        } catch (NullPointerException e){
            model.addAttribute("msg", "Tidak ada detail product yang dapat ditampilkan");
            model.addAttribute("data", "");
            return "product/v_productdetail";
        }
    }
    

}
