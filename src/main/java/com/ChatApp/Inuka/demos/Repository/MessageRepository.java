/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ChatApp.Inuka.demos.Repository;

import com.ChatApp.Inuka.demos.Model.ConversationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;/**/

/**
 * 
 * @author Osias
 */
public interface MessageRepository extends JpaRepository<ConversationModel,Long>{
    /*
    *On recupere tout les messages effectuer entre 2 utilisateurs a partir de leur id(userId1 et userId2)
    *c-a-d, les messages dont le user1 est l'emeteur et le user2 est le recepteur ou le user1 est le recepteur
    *et le user2 est l'emeteur. (On utilise du JPQL pour passer le requet sql)
    */
    @Query(" SELECT c FROM ConversationModel c WHERE "+"(c.em = :userId1 AND c.re = :userId2) "+"OR (c.em = :userId2 AND c.re = :userId1)")
    List<ConversationModel> findConversationBetween(@Param("userId1") Long userId1, @Param("userId2") Long userId2);
}
