
package com.ChatApp.Inuka.demos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Conversation")
public class ConversationModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    @Id//primary_key
    private long Id;
    private long em;
    private long re;
    @CreationTimestamp
    private LocalDateTime dt;
    private String cont;

    public ConversationModel() {
    }

    public ConversationModel(long Id, long em, long re, LocalDateTime dt, String cont) {
        this.Id = Id;
        this.em = em;
        this.re = re;
        this.dt = dt;
        this.cont = cont;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getEm() {
        return em;
    }

    public void setEm(long em) {
        this.em = em;
    }

    public long getRe() {
        return re;
    }

    public void setRe(long re) {
        this.re = re;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
           
}
