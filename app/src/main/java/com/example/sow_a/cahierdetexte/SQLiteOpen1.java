package com.example.sow_a.cahierdetexte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sow-a on 8/6/17.
 */

public class SQLiteOpen1 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="DB_etudiant.db";
    private static final int SCHEMA_VERSION=2;


    private static final String METIER_KEY_COUR = "idCour" ;
    private static final String METIER_COUR_MATIERE = "matiere" ;
    private static final String METIER_COUR_DATE = "date" ;
    private static final String METIER_COUR_HEURE_DEB = "heureDeb" ;
    private static final String METIER_COUR_HEURE_FIN = "heureFin" ;
    private static final String METIER_COUR_DESCRIPTION= "description" ;





    private static final String METIER_TABLE_NAME_COUR = "cour";



    // SQL de création tableau Cours
    public static final String METIER_TABLE_CREATE_COUR =
            "CREATE TABLE " + METIER_TABLE_NAME_COUR + "(" +
                    METIER_KEY_COUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_COUR_MATIERE + " TEXT not null, " +
                    METIER_COUR_DATE + " TEXT not null, " +
                    METIER_COUR_HEURE_DEB+" TEXT not null," +
                    METIER_COUR_HEURE_FIN + " TEXT not null, "+
                    METIER_COUR_DESCRIPTION+ " TEXT not null" +
                    "); ";



    public SQLiteOpen1(Context context) {
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      //  db.execSQL(METIER_TABLE_CREATE_MATIERE) ;
        db.execSQL(METIER_TABLE_CREATE_COUR) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

       // db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_MATIERE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_CREATE_COUR);
             onCreate(db);
    }




}
