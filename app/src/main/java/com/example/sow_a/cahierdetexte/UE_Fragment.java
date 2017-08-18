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
import android.widget.Toast;

import java.util.ArrayList;


public class UE_Fragment extends Fragment {

    private EditText ue,credits ;
    private Spinner spinner ;
    Button button ;
    DAO dao ;


    public UE_Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_ue_, container, false);

        ue = (EditText)view.findViewById(R.id.unite);
        credits = (EditText)view.findViewById(R.id.cr) ;
        spinner = (Spinner)view.findViewById(R.id.spinnerResp) ;
        button = (Button)view.findViewById(R.id.addEU) ;

        ArrayList<String> ms = new ArrayList<>();
        for (int i = 0;i<dao.allProf().size();i++){
            ms.add(dao.allProf().get(i).getNom()+ " "+dao.allProf().get(i).getPrenom());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, ms) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ue.getText().toString() ;
                int c = Integer.parseInt(credits.getText().toString()) ;
                String resp = spinner.getSelectedItem().toString() ;

                ContentValues contentValues = new ContentValues() ;

                contentValues.put("nomUE",n);
                contentValues.put("creditUE",c);
                contentValues.put("responsableUE",resp);

                dao.addUE(contentValues);
                Toast.makeText(getContext(),"succés",Toast.LENGTH_LONG).show();

            }
        });


        return view ;
    }


}
