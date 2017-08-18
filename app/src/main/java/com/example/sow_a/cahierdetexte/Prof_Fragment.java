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
import android.widget.Toast;

import java.util.ArrayList;


public class Prof_Fragment extends Fragment {

   private EditText nom , prenom, specialite,email ;
    private Button addP ;

    private DAO dao ;



    public Prof_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO(getContext()) ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prof_, container, false);

        nom = (EditText)view.findViewById(R.id.nomProf) ;
        prenom = (EditText)view.findViewById(R.id.prenomProf) ;
        specialite = (EditText)view.findViewById(R.id.specialite) ;
        email = (EditText)view.findViewById(R.id.emailPr) ;
        addP = (Button)view.findViewById(R.id.addProf) ;



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
                Toast.makeText(getContext(),"succes",Toast.LENGTH_LONG).show();
            }
        });

        return view ;
    }


}
