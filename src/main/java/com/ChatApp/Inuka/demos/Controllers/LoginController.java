
package com.ChatApp.Inuka.demos.Controllers;

import com.ChatApp.Inuka.demos.Model.UsersModel;
import com.ChatApp.Inuka.demos.Services.UserServices;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //injection de dependances
    @Autowired
    private UserServices serv;
    
    @GetMapping("/log")
    public String Log(Model model, @RequestParam(required=false) String password,
            @RequestParam(required=false) String mail,HttpSession ses){
        
        if(mail != null && password  != null){
            Optional<UsersModel> user = serv.Check(mail, password);//verification de l'existence du user
            if(user.isPresent()){
                UsersModel tt = user.get();
                ses.setAttribute("sessionUser", tt);//ajoute user en session
                return "redirect:/dash";//redirection vers la page principal
            }else{
                model.addAttribute("test", "negatif");
                return "index";
            }
        }

         
         UsersModel us = (UsersModel) ses.getAttribute("sessionUser");//recuper l session
         if(us != null){//verifi si il y a un user en session
             return "redirect:/dash";
         }
        return "index";
    }
    
    @GetMapping("/Logout")
    public String Logout(HttpSession ses){
        ses.removeAttribute("sessionUser");//supprime le user en session
        return "index";
    }
}
