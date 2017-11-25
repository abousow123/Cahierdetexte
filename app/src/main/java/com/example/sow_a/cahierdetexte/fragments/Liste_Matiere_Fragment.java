package com.example.sow_a.cahierdetexte.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Matiere;

import java.util.ArrayList;


public class Liste_Matiere_Fragment extends Fragment {


    ArrayList<Matiere> matiereArrayList ;


    DAO dao ;
    ListView listView ;
    ImageView imageView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO(getContext()) ;
        matiereArrayList = dao.allMatiere() ;


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

          View view = inflater.inflate(R.layout.fragment_liste__matiere_, container, false);


        listView = (ListView)view.findViewById(R.id.listMatiere);



        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;
        listView.setAdapter(adapter);



        // Inflate the layout for this fragment
        return view ;
    }



    class MyListAdapter extends ArrayAdapter<Matiere> {



      public   MyListAdapter() {

            super(Liste_Matiere_Fragment.super.getContext(),R.layout.listview_matiere,matiereArrayList);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater  lis = getActivity().getLayoutInflater() ;
            View row = lis.inflate(R.layout.listview_matiere, parent, false);
            TextView label = (TextView) row.findViewById(R.id.text1);
            //triTabChaine(sg);
            label.setText(matiereArrayList.get(position).getNom_matiere() );

        /*   ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);*/

            return (row);
        }
    }


  /*  class Acomp implements Comparator<Etudiant>{


        @Override
        public int compare(Etudiant a, Etudiant b) {
            return a.getNom().compareToIgnoreCase(b.getNom());
        }



    }*/


}
