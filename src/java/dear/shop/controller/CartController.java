/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dear.shop.controller;

import dear.shop.bean.user.LoginFormBean;
import dear.shop.model.Product;
import dear.shop.model.UserLogin;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/cart")

public class CartController {
    
    private UserLogin user;
    private List<Product> product;
    
    @RequestMapping("/buy/{prodId}")
    public String index(@PathVariable Long prodId, Model model, HttpSession session){
        
        if(session.getAttribute("userlog") != null){
            
            return "cart/v_cart";
        }
        else{
            LoginFormBean loginB = new LoginFormBean();
            model.addAttribute("loginBean", loginB);
            model.addAttribute("msg", "Please Sing In first");
            return "user/v_userLogin";
        }
    }
    
}
