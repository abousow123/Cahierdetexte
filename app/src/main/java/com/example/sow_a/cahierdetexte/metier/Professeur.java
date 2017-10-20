package com.example.sow_a.cahierdetexte.metier;

/**
 * Created by SOW_B on 11/08/2017.
 */

public class Professeur {
    private int id ;
    private String nom ;
    private String prenom ;
    private String specialite ;
    private String email ;


    public Professeur(int id, String nom, String prenom, String specialite,String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.email = email;
    }

    public String toString(){
        return  "Nom:  "+this.nom + "\n"+"Prenom:  "+this.prenom + "\n" + "Spécialité:  " + this.specialite + " ans \n" + "Email:  "+ this.email ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
