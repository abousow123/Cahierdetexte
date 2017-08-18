package com.example.sow_a.cahierdetexte;

/**
 * Created by sow-a on 8/11/17.
 */

public class Etudiant {
    private String nom ;
    private String prenom ;
    private int telephone,id ;
    private  String sexe ;
    private String email ;
    private String formation ;


    //private int _id ;

    //Constructeur
    public Etudiant(String nom, String prenom, String sexe,int telephone,
                    String email,int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.telephone = telephone;
        this.email = email;
        this.id = id ;

    }




    // gettters and setters

    public String getNom() {
        return nom;
    }





    public String toString(){
        return  "Nom:  "+this.nom + "\n"+"Prenom:  "+this.prenom + "\n" + "Telephone:  " + this.telephone + " ans \n" + "Sexe :  "
                + this.sexe + "\nEmail:  "+ this.email ;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
