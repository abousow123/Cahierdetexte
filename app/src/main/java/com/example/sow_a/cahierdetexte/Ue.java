package com.example.sow_a.cahierdetexte;

/**
 * Created by SOW_B on 11/08/2017.
 */

public class Ue {
    private int id ;
    private String nomUE ;
    private int creditUE ;
    private String responsable ;

    public Ue(int id, String nomUE, int creditUE, String responsable) {
        this.id = id;
        this.nomUE = nomUE;
        this.creditUE = creditUE;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUE() {
        return nomUE;
    }

    public void setNomUE(String nomUE) {
        this.nomUE = nomUE;
    }

    public int getCreditUE() {
        return creditUE;
    }

    public void setCreditUE(int creditUE) {
        this.creditUE = creditUE;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
