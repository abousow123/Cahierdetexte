package com.example.sow_a.cahierdetexte;


import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class M_Fragment extends Fragment {

    ArrayList<Matiere> matiereArrayList ;


    Button add ;
    EditText editText1, editText2,editText3 ;
    DAO dao ;

    MainActivity mainActivity;


    public M_Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_m_, container, false);

      //  editText1 = mainActivity.set() ;


       editText2 = (EditText)rootView.findViewById(R.id.editText2) ;
      /*  editText3 = (EditText)getView().findViewById(R.id.editText3) ;
        add = (Button)getView().findViewById(R.id.butAddMatiere) ;

        dao = new DAO() ;*/


/*        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues() ;

                String m = editText1.getText().toString() ;
                String p = editText3.getText().toString() ;
                int v = Integer.parseInt(editText2.getText().toString()) ;

                if (m.equalsIgnoreCase("") || p.equalsIgnoreCase("")
                        || editText2.getText().toString().equalsIgnoreCase("") ) {

                    Toast.makeText(
                            getContext(),
                            "Veuillez entrer tout les informations s'il vous plait !!!",
                            Toast.LENGTH_LONG).show();

                }
                else {

                    contentValues.put("nomMatiere",m);
                    contentValues.put("professeur",p);
                    contentValues.put("volumeHoraire",v);

                    dao.addMatiere(contentValues,getContext());

                    Toast.makeText(getContext(),
                            "succés",
                            Toast.LENGTH_LONG).show();

                }
            }
        });*/





        return rootView ;

    }




}
