/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.controller;

import dear.shop.model.Category;
import dear.shop.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService cs;
    
    public List<Category> getAll(){
        List<Category> cat = cs.getAll();
        return cat;
    }
    
}
