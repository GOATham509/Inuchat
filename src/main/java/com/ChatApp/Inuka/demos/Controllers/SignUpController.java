package com.ChatApp.Inuka.demos.Controllers;

import com.ChatApp.Inuka.demos.Model.UsersModel;
import com.ChatApp.Inuka.demos.Services.UserServices;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    //injection de dependance
    @Autowired
    private UserServices serv;
    
    @PostMapping("/Sign")
    public String Sign(Model model,@RequestParam String nom,@RequestParam String prenom,@RequestParam String profil,@RequestParam String mail
            ,@RequestParam String password2 ,@RequestParam String password,@RequestParam String sexe,@RequestParam String domaine,@RequestParam Date naissance,@RequestParam int numero){
        
        if(password.equals(password2)){
            UsersModel user = new UsersModel();

            user.setNom(nom);
            user.setPrenom(prenom);
            user.setProfil(profil);
            user.setMail(mail);
            user.setPass(password);
            user.setSexe(sexe);
            user.setDomaine(domaine);
            user.setNaissance(naissance);
            user.setNumero(numero);

            String mess = serv.SignUp(user);//tentative d'enregistrement du user
            if(mess.equals("Compte creer avec succes, retourner a la page de connexion")){
                model.addAttribute("message1",mess);
            }else{
                model.addAttribute("message2",mess);
            }
        }else{
            model.addAttribute("message2","Mot de passe non confirme");
        }
        
        return "SignUp";
    }
    
    @GetMapping("/page")
    public String Page(){
        return "SignUp";
    }
}
