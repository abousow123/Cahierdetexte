package com.example.sow_a.cahierdetexte.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by sow-a on 7/18/17.
 */

public class SQLiteOpen extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DB_etudiant.db";
    private static final int SCHEMA_VERSION=5;

    private static final String METIER_KEY = "idMat";
    //   private static final String METIER_KEY_CLASSE = "id_classe";
    private static final String METIER_NOM_MATIERE = "nomMatiere";
    private static final String METIER_VOLOME_HORAIRE = "volumeHoraire";
    private static final String METIER_PROF = "professeur";
    private static final String METIER_UE = "Ue";
    private static final String METIER_CREDIT_HORAIRE = "credit";


    private static final String METIER_KEY_UE = "idUE";
    private static final String METIER_NOM_UE = "nomUE";
    private static final String METIER_CREDIT_UE = "creditUE";
    private static final String METIER_RESPONSABLE_UE = "responsableUE";
    private static final String METIER_MATIERES_UE = "matieresUE";




    private static final String METIER_KEY_COUR = "idcour" ;
    private static final String METIER_COUR_MATIERE = "matiere" ;
    private static final String METIER_COUR_PROF = "professeur" ;
    private static final String METIER_COUR_DATE = "date" ;
    private static final String METIER_COUR_HEURE_DEB = "heuredeb" ;
    private static final String METIER_COUR_HEURE_FIN = "heurefin" ;
    private static final String METIER_COUR_DESCRIPTION= "description" ;


    private static final String METIER_KEY_ETUDIANT = "idEtudiant" ;
    private static final String METIER_NOM = "nom";
    private static final String METIER_PRENOM = "prenom";
    private static final String METIER_SEXE = "sexe";
    private static final String METIER_TELEPHONE = "telephone";
    private static final String METIER_EMAIL = "email";


    private static final String METIER_KEY_PROF = "idProf" ;
    private static final String METIER_NOM_PROF = "nomProf";
    private static final String METIER_PRENOM_PROF = "prenomProf";
    private static final String METIER_SPECIALITE_PROF = "specialite";
    private static final String METIER_EMAIL_PROF = "emailProf";


    // Nom des tables
    private static final String METIER_TABLE_NAME_MATIERE = "matiere";
    private static final String METIER_TABLE_NAME_COUR = "cour";
    private static final String METIER_TABLE_NAME_UE = "ue";
    private static final String METIER_TABLE_NAME_ETUDIANT = "etudiants";
    private static final String METIER_TABLE_NAME_PROFESSEUR = "professeur";





    // SQL de création tableau Cours
    public static final String METIER_TABLE_CREATE_COUR =
            "CREATE TABLE " + METIER_TABLE_NAME_COUR + "(" +
                    METIER_KEY_COUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_COUR_MATIERE + " TEXT, " +
                    METIER_COUR_PROF + " TEXT, " +
                    METIER_COUR_DATE + " TEXT, " +
                    METIER_COUR_HEURE_DEB+" TEXT, " +
                    METIER_COUR_HEURE_FIN + " TEXT, "+
                    METIER_COUR_DESCRIPTION+ " TEXT" +
                    "); ";



    // SQL de création tableau Matiére
    public static final String METIER_TABLE_CREATE_MATIERE =
            "CREATE TABLE " + METIER_TABLE_NAME_MATIERE + "(" +
                    METIER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    METIER_NOM_MATIERE + " TEXT," +
                    METIER_VOLOME_HORAIRE + " INTEGER,"+
                    METIER_PROF+" TEXT" +
                     "); ";


    // SQL de création tableau UE
    public static final String METIER_TABLE_CREATE_UE =
            "CREATE TABLE " + METIER_TABLE_NAME_UE + "(" +
                    METIER_KEY_UE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    METIER_NOM_UE + " TEXT," +
                    METIER_MATIERES_UE + " TEXT"+
                    METIER_CREDIT_UE+" INTEGER," +
                    METIER_RESPONSABLE_UE + " TEXT"+
                    "); ";


    // SQL de création tableau Etudiant
    public static final String METIER_TABLE_CREATE_ETUDIANT =
            "CREATE TABLE " + METIER_TABLE_NAME_ETUDIANT + "(" +
                    METIER_KEY_ETUDIANT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_NOM + " TEXT, " +
                    METIER_PRENOM + " TEXT, "+
                    METIER_SEXE+ " TEXT, "+
                    METIER_TELEPHONE + " INTEGER, "+
                    METIER_EMAIL+" TEXT" +"); ";


    // SQL de création tableau PROFESSEUR
    public static final String METIER_TABLE_CREATE_PROFESSEUR =
            "CREATE TABLE " + METIER_TABLE_NAME_PROFESSEUR + "(" +
                    METIER_KEY_PROF + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    METIER_NOM_PROF + " TEXT," +
                    METIER_PRENOM_PROF + " TEXT,"+
                    METIER_SEXE+ " TEXT, "+
                    METIER_SPECIALITE_PROF+" TEXT," +
                    METIER_EMAIL_PROF+" TEXT" +
                    "); ";





    public SQLiteOpen(Context context) {
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(METIER_TABLE_CREATE_COUR);
        db.execSQL(METIER_TABLE_CREATE_MATIERE) ;
        db.execSQL(METIER_TABLE_CREATE_UE);
        db.execSQL(METIER_TABLE_CREATE_ETUDIANT);
        db.execSQL(METIER_TABLE_CREATE_PROFESSEUR);
       // db.execSQL(METIER_TABLE_CREATE_COUR) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_MATIERE);
        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_COUR);
        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_UE);
        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_ETUDIANT);
        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_PROFESSEUR);
        onCreate(db);
    }


}
