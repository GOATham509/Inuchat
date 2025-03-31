/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ChatApp.Inuka.demos.Repository;

import com.ChatApp.Inuka.demos.Model.UsersModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersModel,Long>{
    Optional<UsersModel> findByMailAndPass(String mail, String password);//recupere user a partir de son mail&password
    Optional<UsersModel> findByMail(String mail);//check l'existence d'un mail
    Optional<UsersModel> findByPass(String password);//check l'existence d'un password
}
