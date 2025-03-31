
package com.ChatApp.Inuka.demos.Services;

import com.ChatApp.Inuka.demos.Model.ConversationModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChatApp.Inuka.demos.Repository.MessageRepository;

/**
 *
 * @author Osias Jephthe
 */
@Service
public class ConversationServices {
    //injection de dependance
    @Autowired
    private MessageRepository repository;
    
    public List<ConversationModel> chat(Long id1, Long id2){
        return repository.findConversationBetween(id1 , id2);
    }/**/
    
    /**
     * /
     * @param chats
     */
    public void SaveChat(ConversationModel chats){
       repository.save(chats);//enregistre un message passe en parametre
    }
}
