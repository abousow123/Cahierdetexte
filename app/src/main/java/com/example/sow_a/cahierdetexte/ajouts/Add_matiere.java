package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.fragments.List_matieres;
import com.example.sow_a.cahierdetexte.metier.Matiere;

import java.util.ArrayList;

public class Add_matiere extends AppCompatActivity {

    ArrayList<Matiere> matiereArrayList ;

    Bundle extra ;

    Spinner spinnerProf;
    Button add ;
    EditText editTextNom,editTextVolumeHoraire ;
    DAO dao ;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_matiere);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager() ;
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getFragmentManager().getBackStackEntryCount() == 0){
                    List_matieres list_matieres = new List_matieres() ;
                    fragmentTransaction = fragmentManager.beginTransaction() ;
                    fragmentTransaction.replace(R.id.sss,list_matieres) ;
                    fragmentTransaction.commit() ;
                    finish();
                }
            }
        });


        editTextNom = (EditText)findViewById(R.id.editText) ;


        editTextVolumeHoraire = (EditText)findViewById(R.id.editText3) ;
        add = (Button)findViewById(R.id.butAddMatiere) ;
        spinnerProf = (Spinner)findViewById(R.id.spinner2) ;
        spinnerProf.getPopupBackground() ;


        dao = new DAO(getApplicationContext()) ;

        ArrayList<String> listProf = new ArrayList<>();

        for (int i = 0;i<dao.allProf().size();i++){
            listProf.add(dao.allProf().get(i).getPrenom() +" "+dao.allProf().get(i).getNom());
        }



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listProf) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerProf.setAdapter(dataAdapter);

        extra = getIntent().getExtras();

        if(extra != null) chargerInfoEtudiant();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues() ;

                String nom = editTextNom.getText().toString() ;
                String p = spinnerProf.getSelectedItem().toString();

                String b = editTextVolumeHoraire.getText().toString() ;
                int v = Integer.parseInt(b) ;

                if (nom.equalsIgnoreCase("") || p.equalsIgnoreCase("")
                        || editTextVolumeHoraire.getText().toString().equalsIgnoreCase("") ) {

                    Toast.makeText(
                            getApplicationContext(),
                            "Veuillez entrer tout les informations s'il vous plait !!!",
                            Toast.LENGTH_LONG).show();

                }
                else {

                    contentValues.put("nomMatiere",nom);
                    contentValues.put("volumeHoraire",v);
                    contentValues.put("professeur",p);


                    String text = "";



                    Toast.makeText(getApplicationContext(),
                            "succés",
                            Toast.LENGTH_LONG).show();

                    if(extra == null) {
                        dao.addMatiere(contentValues);
                        text = nom +", Ajouter avec succés !!!";
                    }
                    else {
                        dao.updateMatiere(contentValues, extra.getInt("idMat"));
                        text= "Mofication effectué avec succès";
                    }



                }
            }
        });


        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                this.finish();


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void chargerInfoEtudiant() {
        this.editTextNom.setText(extra.getString("nomMatiere"));
        this.editTextVolumeHoraire.setText(String.valueOf(extra.getInt("volumeHoraire")));


    }

}
