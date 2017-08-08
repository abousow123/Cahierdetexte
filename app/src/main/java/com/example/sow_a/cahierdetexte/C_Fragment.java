package com.example.sow_a.cahierdetexte;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class C_Fragment extends Fragment {

    TimePicker deb,fin ;
    Spinner spinner ;
    EditText description ;
    Button button ;

    DAO dao ;



    public C_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_c_, container, false);

        spinner = (Spinner)v.findViewById(R.id.spinner) ;
        deb = (TimePicker)v.findViewById(R.id.timePicker4) ;
        fin = (TimePicker)v.findViewById(R.id.timePicker2) ;
        description = (EditText)v.findViewById(R.id.editText5) ;
        button = (Button)v.findViewById(R.id.buttonCour) ;




        deb.setIs24HourView(true);
        fin.setIs24HourView(true);

        dao = new DAO() ;
        ArrayList<String> ms = new ArrayList<>();
        for (int i = 0;i<dao.allMatiere(getContext()).size();i++){
            ms.add(dao.allMatiere(getContext()).get(i).getNom_matiere());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, ms) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String des = description.getText().toString() ;

                int  debut = deb.getCurrentHour() ;
                int  debut1 = deb.getCurrentMinute() ;
                String dT = debut+"h"+debut1 ;

                int f = fin.getCurrentHour() ;
                int f1 = fin.getCurrentMinute() ;
                String ft = f + "h" + f1 ;

                String sp = spinner.getSelectedItem().toString() ;
                String d = getDateTime().toString() ;

                ContentValues contentValues = new ContentValues() ;

                contentValues.put("matiere",sp);
                contentValues.put("date",d);
                contentValues.put("heureDeb",dT);
                contentValues.put("heureFin",ft);
                contentValues.put("description",des);

                dao.addCour(contentValues,getContext());

                Toast.makeText(getContext(),"succes",Toast.LENGTH_LONG).show();



            }
        });

        return v;
    }

    public static Date getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        return date;
    }



}
