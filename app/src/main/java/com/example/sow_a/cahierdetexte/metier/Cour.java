package com.example.sow_a.cahierdetexte.metier;

/**
 * Created by sow-a on 8/2/17.
 */

public class Cour {
    private int id ;
    private String matiere ;
    private String heureDeb ;
    private String heureFin ;
    private String description ;
    private String date ;
    private String prof ;

    public Cour(int id, String matiere,String prof, String date, String heureDeb, String heureFin,String description) {
        this.id = id;
        this.matiere = matiere;
        this.prof = prof ;
        this.date = date ;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
        this.description = description;
    }




    public String toString(){
        return  "Matière:  "+this.matiere + "\n"+"Heure début:  "+this.heureDeb + "\n" + "Heure Fin: " +
                this.heureFin +"\nDescription du cours: "+this.description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}
