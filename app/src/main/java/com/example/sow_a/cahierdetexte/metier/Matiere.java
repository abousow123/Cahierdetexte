package com.example.sow_a.cahierdetexte.metier;

/**
 * Created by sow-a on 7/18/17.
 */

public class Matiere {
    private String nom_matiere ;
    private String prof ;
    private int volumeH, id ;


    public  Matiere(String nom_matiere,String prof,int volumeH,int id){
        this.nom_matiere = nom_matiere ;
        this.prof = prof ;
        this.volumeH = volumeH ;
        this.id = id ;
    }

    public String toString(){
        return  "Matière:  "+this.nom_matiere + "\n"+"Professeur:  "+this.prof + "\n" + "Volume horaire:  " + this.volumeH +"heures"+
                "\n"+"Unités d'enseignement:";
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public int getVolumeH() {
        return volumeH;
    }

    public void setVolumeH(int volumeH) {
        this.volumeH = volumeH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
