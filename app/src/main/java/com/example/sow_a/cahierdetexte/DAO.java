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

//	public EtudiantDAO(Context context) {
//		db = (new SQLiteOpen(context)).getWritableDatabase();
//
//	}
public ArrayList<Cour> allCour(Context context){
    ArrayList<Cour>  listCour = new ArrayList<Cour>() ;
    db = (new SQLiteOpen1(context)).getReadableDatabase();
    Cursor resul = db.rawQuery("SELECT idCour,matiere,date,heureDeb,heureFin,description FROM cour;",null) ;

    resul.moveToFirst() ;

    while(!resul.isAfterLast()){

        int idc = resul.getInt(resul.getColumnIndex("idCour"));
        String matiereCour = resul.getString(resul.getColumnIndex("matiere"));
        String date = resul.getString(resul.getColumnIndex("date"));
        String heureD = resul.getString(resul.getColumnIndex("heureDeb")) ;
        String heureF = resul.getString(resul.getColumnIndex("heureFin")) ;
        String Dec = resul.getString(resul.getColumnIndex("description")) ;


        listCour.add(new Cour(idc,matiereCour,date,heureD,heureF,Dec)) ;

        resul.moveToNext() ;
    }

    resul.close();

    return  listCour ;
}

    public void addMatiere(ContentValues cv, Context context) {
        db = (new SQLiteOpen(context)).getWritableDatabase();
        db.insert("matiere",null, cv);

    }

    public void addCour(ContentValues cv, Context context) {
        db = (new SQLiteOpen(context)).getWritableDatabase();
        db.insert("cour",null, cv);

    }

    public void updateMatiere(ContentValues cv, int id,Context context) {
        db = (new SQLiteOpen(context)).getWritableDatabase();
        db.update("matiere", cv, "id=" + id, null);
    }

    public void deleteMatiere(int id,Context context) {
        db = (new SQLiteOpen(context)).getWritableDatabase();
        db.delete("matiere", "id=" + id, null);
    }

    public ArrayList<Matiere> allMatiere(Context context){
        ArrayList<Matiere>  listMatiere = new ArrayList<Matiere>() ;
        db = (new SQLiteOpen(context)).getReadableDatabase();
        Cursor result = db.rawQuery("SELECT idMat,nomMatiere,professeur,volumeHoraire from matiere;",null) ;

        result.moveToFirst() ;

        while(!result.isAfterLast()){

            int id = result.getInt(result.getColumnIndex("idMat"));
            String nom = result.getString(result.getColumnIndex("nomMatiere"));
            String prof = result.getString(result.getColumnIndex("professeur"));
            int v = result.getInt(result.getColumnIndex("volumeHoraire")) ;


            listMatiere.add(new Matiere(nom,prof,v,id)) ;

            result.moveToNext() ;
        }

        result.close();

        return  listMatiere ;
    }




}
