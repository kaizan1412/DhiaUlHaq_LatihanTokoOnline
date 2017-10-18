/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.controller;

import dear.shop.model.Category;
import dear.shop.service.CategoryService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    CategoryService cs;
    
    @RequestMapping()
    public String index(HttpSession sess, Model model) {
        List<Category> category = cs.getAll();
        model.addAttribute("cate", category);
        sess.setAttribute("pageview", "home");
        return "home";
    }

}
