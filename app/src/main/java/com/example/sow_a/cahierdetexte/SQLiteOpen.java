package com.example.sow_a.cahierdetexte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by sow-a on 7/18/17.
 */

public class SQLiteOpen extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DB_etudiant.db";
    private static final int SCHEMA_VERSION=1;

    private static final String METIER_KEY = "idMat";
    //   private static final String METIER_KEY_CLASSE = "id_classe";
    private static final String METIER_NOM_MATIERE = "nomMatiere";
    private static final String METIER_VOLOME_HORAIRE = "volumeHoraire";
    private static final String METIER_PROF = "professeur";

    private static final String METIER_KEY_COUR = "idCour" ;
    private static final String METIER_COUR_MATIERE = "matiere" ;
    private static final String METIER_COUR_DATE = "date" ;
    private static final String METIER_COUR_HEURE_DEB = "heureDeb" ;
    private static final String METIER_COUR_HEURE_FIN = "heureFin" ;
    private static final String METIER_COUR_DESCRIPTION= "description" ;





    private static final String METIER_TABLE_NAME_MATIERE = "matiere";
    private static final String METIER_TABLE_NAME_COUR = "cour";

    // SQL de création tableau Matiére
    public static final String METIER_TABLE_CREATE_MATIERE =
            "CREATE TABLE " + METIER_TABLE_NAME_MATIERE + "(" +
                    METIER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_NOM_MATIERE + " TEXT, " +
                    METIER_PROF+" TEXT," +
                    METIER_VOLOME_HORAIRE + " INTEGER "+
                     "); ";

    // SQL de création tableau Cours
    public static final String METIER_TABLE_CREATE_COUR =
            "CREATE TABLE " + METIER_TABLE_NAME_MATIERE + "(" +
                    METIER_KEY_COUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_COUR_DATE + " TEXT, " +
                    METIER_COUR_HEURE_DEB+" TEXT," +
                    METIER_COUR_HEURE_FIN + " TEXT, "+
                    METIER_COUR_DESCRIPTION+ "TEXT" +
                    "); ";



    public SQLiteOpen(Context context) {
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(METIER_TABLE_CREATE_MATIERE) ;
        db.execSQL(METIER_TABLE_CREATE_COUR) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_MATIERE);
         db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_CREATE_COUR);
        onCreate(db);
    }


}
