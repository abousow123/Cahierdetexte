package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;

public class Add_professeur extends AppCompatActivity {

    private EditText nom , prenom, specialite,email ;
    private Button addP ;

    private DAO dao ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_professeur);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = new DAO(getApplicationContext()) ;


        nom = (EditText)findViewById(R.id.editText1) ;
        prenom = (EditText)findViewById(R.id.editText2) ;
        specialite = (EditText)findViewById(R.id.editText5) ;
        email = (EditText)findViewById(R.id.editText4) ;
        addP = (Button)findViewById(R.id.ajou) ;



        addP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nom.getText().toString() ;
                String p = prenom.getText().toString() ;
                String s = specialite.getText().toString() ;
                String e = email.getText().toString() ;

                ContentValues ct = new ContentValues() ;

                ct.put("nomProf",n);
                ct.put("prenomProf",p);
                ct.put("specialite",s);
                ct.put("emailProf",e);

                dao.addProf(ct);
                Toast.makeText(getApplicationContext(),"succes",Toast.LENGTH_LONG).show();
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
                this.finish(); ;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
