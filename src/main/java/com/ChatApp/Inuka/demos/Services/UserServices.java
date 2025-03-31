package com.ChatApp.Inuka.demos.Services;

import com.ChatApp.Inuka.demos.Repository.UserRepository;
import com.ChatApp.Inuka.demos.Model.UsersModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<UsersModel> getAllUser(){
        return userRepository.findAll();
    }
    
    public Optional<UsersModel> Check(String mail, String pass){
        return userRepository.findByMailAndPass(mail, pass);
    }
    
    public Optional<UsersModel> Recepteur(Long id){
        return userRepository.findById(id);
    }
    
    public String SignUp(UsersModel user){
        if(userRepository.findByMail(user.getMail()).isEmpty()){
            if(userRepository.findByPass(user.getPass()).isEmpty()){
                userRepository.save(user);
            }else{
                return "Mot de pass non valide";
            }
        }else{
            return "Mail non valide";
        }
        
        return "Compte creer avec succes, retourner a la page de connexion";
    }
}
