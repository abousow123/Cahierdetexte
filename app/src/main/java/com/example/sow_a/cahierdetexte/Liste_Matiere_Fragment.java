package com.example.sow_a.cahierdetexte;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class Liste_Matiere_Fragment extends Fragment {


    ArrayList<Matiere> matiere ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste__matiere_, container, false);
      //  matiere = new ArrayList<Matiere>() ;
    }



   /* class MyListAdapter extends ArrayAdapter<Matiere> {
        MyListAdapter() {

            super(Liste_Matiere_Fragment.this, R.layout.listview_matiere,matiere);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.listeview, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textView1);
            //triTabChaine(sg);
            label.setText(etudiants.get(position).getNom() + " "
                    + etudiants.get(position).getPrenom());

           ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);

            return (row);
        }
    } */


  /*  class Acomp implements Comparator<Etudiant>{


        @Override
        public int compare(Etudiant a, Etudiant b) {
            return a.getNom().compareToIgnoreCase(b.getNom());
        }



    }*/


}
