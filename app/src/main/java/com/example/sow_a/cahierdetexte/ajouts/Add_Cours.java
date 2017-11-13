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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Add_Cours extends AppCompatActivity {

    TimePicker deb,fin ;
    Spinner spinner, spinner1 ;
    EditText description ;
    Button button ;

    DAO dao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__cours);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner)findViewById(R.id.spinner) ;
        spinner1 = (Spinner)findViewById(R.id.spinner4) ;
        deb = (TimePicker)findViewById(R.id.timePicker4) ;
        fin = (TimePicker)findViewById(R.id.timePicker2) ;
        description = (EditText)findViewById(R.id.editText5) ;
        button = (Button)findViewById(R.id.buttonCour) ;




        deb.setIs24HourView(true);
        fin.setIs24HourView(true);

        dao = new DAO(getApplicationContext()) ;
        ArrayList<String> ms = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();
        for (int i = 0;i<dao.allMatiere().size();i++){
            ms.add(dao.allMatiere().get(i).getNom_matiere());
        }

        for (int i = 0;i<dao.allProf().size();i++){
            ps.add(dao.allProf().get(i).getPrenom() + " " + dao.allProf().get(i).getNom());
        }


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ms) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ps) ;

        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner1.setAdapter(dataAdapter1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String des = description.getText().toString() ;

                int  debut = 0;  //deb.getCurrentHour() ;
                int  debut1 =  12; deb.getCurrentMinute() ;
                String dT = debut+"h"+debut1 ;

                int f =  1;   //fin.getCurrentHour() ;
                int f1 =  25;    //fin.getCurrentMinute() ;
                String ft = f + "h" + f1 ;

                String sp = spinner.getSelectedItem().toString() ;
                String s = spinner1.getSelectedItem().toString() ;
                String d = getDateTime() ;

                ContentValues contentValues = new ContentValues() ;

                contentValues.put("matiere",sp);
                contentValues.put("date",d);
                contentValues.put("professeur",s);
                contentValues.put("heuredeb",dT);
                contentValues.put("heurefin",ft);
                contentValues.put("description",des);

                dao.addCour(contentValues);

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


    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();

         ;
        return dateFormat.format(date);
    }

}
