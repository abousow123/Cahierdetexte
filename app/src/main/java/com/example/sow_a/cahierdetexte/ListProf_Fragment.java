package com.example.sow_a.cahierdetexte;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListProf_Fragment extends Fragment {

    ListView listView;
    ImageView iconne;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;

//	private AutoCompleteTextView autoCompleteTextView;
    //String sg[] ;

    DAO dao ;
    ArrayList<Professeur> professeurs ;


    public ListProf_Fragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO(getContext());
        professeurs = dao.allProf() ;
        fragmentManager = getFragmentManager() ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_prof_, container, false);


        listView = (ListView)view.findViewById(R.id.listViewPro);

        iconne = (ImageView)view.findViewById(R.id.butAjoutProf) ;

        ArrayAdapter<Professeur> adapter = new MyListAdapter() ;
        listView.setAdapter(adapter);
        // fragmentManager = getArguments() ;

        iconne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Prof_Fragment prof_fragment = new Prof_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,prof_fragment) ;
                fragmentTransaction.commit() ;


            }
        });



        return view ;
    }

    class MyListAdapter extends ArrayAdapter<Professeur> {
        MyListAdapter() {

            super(ListProf_Fragment.super.getContext(), R.layout.listetudiant_suit,professeurs);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.listetudiant_suit, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textView1);
            //triTabChaine(sg);
            label.setText(professeurs.get(position).getNom() + " "
                    + professeurs.get(position).getPrenom());

           /* ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);*/

            return (row);
        }
    }



}






