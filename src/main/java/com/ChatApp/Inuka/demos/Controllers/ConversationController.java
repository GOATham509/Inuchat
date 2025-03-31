
package com.ChatApp.Inuka.demos.Controllers;

import com.ChatApp.Inuka.demos.Model.ConversationModel;
import com.ChatApp.Inuka.demos.Model.UsersModel;
import com.ChatApp.Inuka.demos.Services.ConversationServices;
import com.ChatApp.Inuka.demos.Services.UserServices;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Osias
 */
@Controller
@SessionAttributes("idR")//(idR = id Recepteur)
public class ConversationController {
    //injections de depandence
    @Autowired
    ConversationServices convers;
    @Autowired
    UserServices userService;
    
    @GetMapping("/chat")
    public String message(@RequestParam(required=false) Long id, Model model,HttpSession ses){
        String name;
        if(id != null){
            model.addAttribute("idR",id);//ajoute le recepteur en session
        }
        
        UsersModel us = (UsersModel) ses.getAttribute("sessionUser");//recuperer user en session
        Long idr = (Long) model.getAttribute("idR");//id du recepteur
        Optional<UsersModel> user = userService.Recepteur(idr);//recherche le recepteur par son id
        UsersModel rec = user.get();
        name = rec.getNom()+" "+rec.getPrenom();
        model.addAttribute("nameR",name);//envoie son nom vers le vue
        
        if(us != null){
            model.addAttribute("userSession", us);//envoie l'utilisateur en session vers l'HTML
            List<ConversationModel> lis = convers.chat(us.getId(), idr);//La liste des messages(entre 2 users)
            if(!lis.isEmpty()){
                model.addAttribute("chats",lis);
            }
        }else{
            return "index";
        }
        return "message";
    }
    
    @GetMapping("/send_message")//pour enregistrer un message
    public String Chats(@RequestParam String message, Model model, HttpSession ses){
       UsersModel us = (UsersModel) ses.getAttribute("sessionUser");//recuperer user en session
       Long id = (Long) model.getAttribute("idR");//id du recepteur
       
        if(us != null){
            if(id != null){
                if(!message.isBlank()){//verifie si le contenue(message) n'est pas une espace blanche
                    ConversationModel con = new ConversationModel();
                    con.setCont(message);
                    con.setEm(us.getId());
                    con.setRe(id);
                    con.setDt(LocalDateTime.MIN);
                    convers.SaveChat(con);//enregistre le message
                }
            }
        }else{
            return "index";
        }
        
        return "redirect:/chat";//redirection vers la methode chat()
    }
    
}
