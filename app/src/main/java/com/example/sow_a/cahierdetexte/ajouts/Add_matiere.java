package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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



    Spinner spinnerProf;
    Button add ;
    EditText editText1,editText3 ;
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


        editText1 = (EditText)findViewById(R.id.editText) ;


        editText3 = (EditText)findViewById(R.id.editText3) ;
        add = (Button)findViewById(R.id.butAddMatiere) ;
        spinnerProf = (Spinner)findViewById(R.id.spinner2) ;
        spinnerProf.getPopupBackground() ;


        dao = new DAO(getApplicationContext()) ;

        ArrayList<String> ms = new ArrayList<>();

        for (int i = 0;i<dao.allProf().size();i++){
            ms.add(dao.allProf().get(i).getPrenom() +" "+dao.allProf().get(i).getNom());
        }



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ms) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerProf.setAdapter(dataAdapter);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues() ;

                String m = editText1.getText().toString() ;
                String p = spinnerProf.getSelectedItem().toString();

                String b = editText3.getText().toString() ;
                int v = Integer.parseInt(b) ;

                if (m.equalsIgnoreCase("") || p.equalsIgnoreCase("")
                        || editText3.getText().toString().equalsIgnoreCase("") ) {

                    Toast.makeText(
                            getApplicationContext(),
                            "Veuillez entrer tout les informations s'il vous plait !!!",
                            Toast.LENGTH_LONG).show();

                }
                else {

                    contentValues.put("nomMatiere",m);
                    contentValues.put("volumeHoraire",v);
                    contentValues.put("professeur",p);



                    dao.addMatiere(contentValues);

                    Toast.makeText(getApplicationContext(),
                            "succés",
                            Toast.LENGTH_LONG).show();



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

}
