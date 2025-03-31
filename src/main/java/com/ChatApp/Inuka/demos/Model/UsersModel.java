package com.ChatApp.Inuka.demos.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Users")
public class UsersModel {
    @Id//primary_key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    
    private Long Id;
    private String profil;
    private String nom;
    private String prenom;
    private String sexe;
    private Date naissance;
    private String domaine;
    
    @Column(unique = true, nullable = false)
    private int numero;
    
    @Column(unique = true, nullable = false)//unique et non null
     private String pass;
    
    @Column(unique = true, nullable = false)//unique et non null
     private String mail;


    public UsersModel() {
    }

    public UsersModel(Long Id, String profil, String nom, String prenom, String sexe, Date naissance, 
            String domaine, String pass, String mail, int numero) {
        this.Id = Id;
        this.profil = profil;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.naissance = naissance;
        this.domaine = domaine;
        this.pass = pass;
        this.mail = mail;
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
