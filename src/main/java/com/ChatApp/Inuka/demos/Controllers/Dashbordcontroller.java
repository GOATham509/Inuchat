package com.ChatApp.Inuka.demos.Controllers;

import com.ChatApp.Inuka.demos.Model.UsersModel;
import com.ChatApp.Inuka.demos.Services.UserServices;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Dashbordcontroller{
    //injection de dependance
    @Autowired
    private UserServices rep;
    
    @GetMapping("dash")
    public String affichage(Model model, HttpSession ses){
        //recuperer user en session
        UsersModel us = (UsersModel) ses.getAttribute("sessionUser");
        if(us == null){//si pas de user en session
            return "index";
        }else{
            //recuperation de tout les users
            List<UsersModel> lis = rep.getAllUser();
            lis.removeIf(user -> user.getId().equals(us.getId())); //enlever le user en session de la liste a afficher
            model.addAttribute("Users", lis);//liste des utilisateurs
            model.addAttribute("userSession", us);//utilisateur en session
            return "contact";
        }
    }
}