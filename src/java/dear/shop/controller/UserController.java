/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.controller;

import dear.shop.bean.user.LoginFormBean;
import dear.shop.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService us;
    
    @RequestMapping()
    public String index(Model model){
        LoginFormBean loginBean = new LoginFormBean();
        model.addAttribute("loginBean", loginBean);
        return "user/v_userLogin";
    }
        
    @RequestMapping("validate")
    public String validateLogin(HttpSession sess, @ModelAttribute("loginBean") LoginFormBean loginBean, Model model){
        
        String pageview = (String) sess.getAttribute("pageview");
        Boolean cek = us.validasi(loginBean.getUsername(), loginBean.getPassword());
        if(cek){
            sess.setAttribute("userlog", loginBean.getUsername());
            return pageview;
        }
        else{
            sess.setAttribute("userlog", null);
            model.addAttribute("msg", "Username dan Password tidak cocok !");
            return "user/v_userLogin";
        }
        
    }
    
}
