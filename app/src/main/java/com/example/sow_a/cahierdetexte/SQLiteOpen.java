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


    private static final String METIER_TABLE_NAME_MATIERE = "matiere";

    // SQL de création tableau Etudiant
    public static final String METIER_TABLE_CREATE_MATIERE =
            "CREATE TABLE " + METIER_TABLE_NAME_MATIERE + "(" +
                    METIER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_NOM_MATIERE + " TEXT, " +
                    METIER_PROF+" TEXT," +
                    METIER_VOLOME_HORAIRE + " INTEGER "+
                     "); ";



    public SQLiteOpen(Context context) {
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(METIER_TABLE_CREATE_MATIERE) ;
        //db.execSQL(METIER_TABLE_CREATE_CLASSE) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_MATIERE);
        // db.execSQL("DROP TABLE IF EXISTS "+METIER_TABLE_NAME_CLASSE);
        onCreate(db);
    }


}
