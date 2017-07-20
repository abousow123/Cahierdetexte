package com.example.sow_a.cahierdetexte;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Liste_Matiere_Fragment extends Fragment {


    ArrayList<Matiere> matiereArrayList ;


    DAO dao ;
    ListView listView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO() ;
        matiereArrayList = dao.allMatiere(getContext()) ;
        //  listView = (ListView)getView()findViewById(R.id.listMatiere); ;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;
//        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste__matiere_, container, false);

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
