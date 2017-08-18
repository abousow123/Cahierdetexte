package com.example.sow_a.cahierdetexte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sow-a on 7/18/17.
 */

public class DAO {

    SQLiteDatabase db;
    SQLiteDatabase db1 ;

	public DAO(Context context) {
		db = (new SQLiteOpen(context)).getWritableDatabase();

	}


	// ******************* DAO COURS **********************

    public ArrayList<Cour> allCour(){
    ArrayList<Cour>  listCour = new ArrayList<Cour>() ;
   // db = (new SQLiteOpen(context)).getWritableDatabase();
    Cursor resul = db.rawQuery("SELECT * from cour;",null) ;

    resul.moveToFirst() ;

        while(!resul.isAfterLast()){

        int idc = resul.getInt(resul.getColumnIndex("idcour"));
        String matiereCour = resul.getString(resul.getColumnIndex("matiere"));
        String date = resul.getString(resul.getColumnIndex("date"));
        String heureD = resul.getString(resul.getColumnIndex("heuredeb")) ;
        String heureF = resul.getString(resul.getColumnIndex("heurefin")) ;
        String Dec = resul.getString(resul.getColumnIndex("description")) ;


        listCour.add(new Cour(idc,matiereCour,date,heureD,heureF,Dec)) ;

        resul.moveToNext() ;
        }

       resul.close();

      return  listCour ;
    }

    public void addCour(ContentValues cv) {
        //  db = (new SQLiteOpen(context)).getWritableDatabase();
        db.insert("cour",null, cv);

    }


    // ******************* DAO MATIERES **********************

    public void addMatiere(ContentValues cv) {
      //  db = (new SQLiteOpen(context)).getWritableDatabase();
        db.insert("matiere",null, cv);

    }


    public void updateMatiere(ContentValues cv, int id) {
       // db = (new SQLiteOpen(context)).getWritableDatabase();
        db.update("matiere", cv, "idMat=" + id, null);
    }

    public void deleteMatiere(int id) {
       // db = (new SQLiteOpen(context)).getWritableDatabase();
        db.delete("matiere", "idMat=" + id, null);
    }

    public ArrayList<Matiere> allMatiere(){
        ArrayList<Matiere>  listMatiere = new ArrayList<Matiere>() ;
       // db = (new SQLiteOpen(context)).getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * from matiere;",null) ;

        result.moveToFirst() ;

        while(!result.isAfterLast()){

            int id = result.getInt(result.getColumnIndex("idMat"));
            String nom = result.getString(result.getColumnIndex("nomMatiere"));
            String prof = result.getString(result.getColumnIndex("professeur"));
            int v = result.getInt(result.getColumnIndex("volumeHoraire")) ;
            String ue = result.getString(result.getColumnIndex("Ue"));


            listMatiere.add(new Matiere(nom,prof,v,ue,id)) ;

            result.moveToNext() ;
        }

        result.close();

        return  listMatiere ;
    }


    // *******************   DAO ETUDIANTS  ****************************************

    public void addEtudiant(ContentValues cv) {
        db.insert("etudiants",null, cv);

    }

    public void updateEtudiant(ContentValues cv, int id) {
        db.update("etudiants", cv, "idEtudiant=" + id, null);
    }

    public void deleteEtudiant(int id) {
        db.delete("etudiants", "idEtudiant=" + id, null);
    }

    public ArrayList<Etudiant> allEtudiants(){
        ArrayList<Etudiant>  listEtudiant = new ArrayList<Etudiant>() ;
        Cursor result = db.rawQuery("SELECT idEtudiant,nom,prenom,sexe,telephone,email from etudiants;",null) ;

        result.moveToFirst() ;

        while(!result.isAfterLast()){

            int id = result.getInt(result.getColumnIndex("idEtudiant"));
            String nom = result.getString(result.getColumnIndex("nom"));
            String prenom = result.getString(result.getColumnIndex("prenom"));
            String sexe = result.getString(result.getColumnIndex("sexe"));
            int telephone = result.getInt(result.getColumnIndex("telephone")) ;
            String email = result.getString(result.getColumnIndex("email"));

            listEtudiant.add(new Etudiant(nom,prenom,sexe,telephone,email,id)) ;

            result.moveToNext() ;
        }

        result.close();

        return  listEtudiant ;
    }


    // ******************* DAO UE **********************

    public void addUE(ContentValues cv) {
        db.insert("ue",null, cv);

    }

    public void updateUE(ContentValues cv, int id) {
        db.update("ue", cv, "idUE=" + id, null);
    }

    public void deleteUE(int id) {
        db.delete("ue", "idUE=" + id, null);
    }

    public ArrayList<Ue> allUE(){
        ArrayList<Ue>  listUE = new ArrayList<Ue>() ;
        Cursor result = db.rawQuery("SELECT * from ue;",null) ;

        result.moveToFirst() ;

        while(!result.isAfterLast()){

            int id = result.getInt(result.getColumnIndex("idUE"));
            String nom = result.getString(result.getColumnIndex("nomUE"));
            int credit = result.getInt(result.getColumnIndex("creditUE")) ;
            String responsable = result.getString(result.getColumnIndex("responsableUE"));

            listUE.add(new Ue(id,nom,credit,responsable)) ;

            result.moveToNext() ;
        }

        result.close();

        return  listUE ;
    }

    // ***************************** DAO PROFESSEUR  *****************************************************************

    public void addProf(ContentValues cv) {
        db.insert("professeur",null, cv);

    }

    public ArrayList<Professeur> allProf(){
        ArrayList<Professeur>  listProf = new ArrayList<Professeur>() ;
        Cursor result = db.rawQuery("SELECT * from professeur;",null) ;

        result.moveToFirst() ;

        while(!result.isAfterLast()){

            int id = result.getInt(result.getColumnIndex("idProf"));
            String nom = result.getString(result.getColumnIndex("nomProf"));
            String prenom = result.getString(result.getColumnIndex("prenomProf"));
            String specialite = result.getString(result.getColumnIndex("specialite"));
            String emal = result.getString(result.getColumnIndex("emailProf"));

            listProf.add(new Professeur(id,nom,prenom,specialite,emal)) ;

            result.moveToNext() ;
        }

        result.close();

        return  listProf ;
    }




}
