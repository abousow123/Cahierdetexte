package com.example.sow_a.cahierdetexte;

/**
 * Created by sow-a on 8/11/17.
 */

public class Etudiant {
    private String nom ;
    private String prenom ;
    private int age,id ;
    private  String sexe ;
    private String email ;
    private String formation ;


    //private int _id ;

    //Constructeur
    public Etudiant(String nom, String prenom, int age, String sexe,
                    String email,int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.email = email;
        this.id = id ;

    }




    // gettters and setters

    public String getNom() {
        return nom;
    }





    public String toString(){
        return  "Nom:  "+this.nom + "\n"+"Prenom:  "+this.prenom + "\n" + "Age:  " + this.age + " ans \n" + "Sexe :  "
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
