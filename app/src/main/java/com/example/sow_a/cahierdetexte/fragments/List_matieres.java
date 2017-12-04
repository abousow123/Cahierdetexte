package com.example.sow_a.cahierdetexte.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.ajouts.Add_matiere;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Matiere;

import java.util.ArrayList;


public class List_matieres extends Fragment {

    ImageView butAjoutMatiere ;

    ArrayList<Matiere> matiereArrayList ;


    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;
    ListView listViewtab1,listViewtab3 ;



    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;


    public List_matieres() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO(getContext()) ;
        matiereArrayList = dao.allMatiere() ;




        fragmentManager = getFragmentManager() ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_list_matieres, container, false);

        // rootView.setOnKeyListener(pressed);

        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;


        listViewtab1 = (ListView)rootView.findViewById(R.id.listMatiere);

        butAjoutMatiere = (ImageView) rootView.findViewById(R.id.butAjoutMatiere) ;
        butAjoutMatiere.setImageResource(R.mipmap.addmat);

        listViewtab1.setAdapter(adapter);

        listViewtab1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Matiere matiere = matiereArrayList.get(i) ;

                final AlertDialog.Builder builder = new AlertDialog.Builder(
                        getContext());

                builder.setMessage(matiere.toString());

                builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent it = new Intent(List_matieres.super.getContext(),Add_matiere.class) ;


                        ;


                        it.putExtra("idMat",matiere.getId());
                        it.putExtra("nomMatiere", matiere.getNom_matiere());
                        it.putExtra("volumeHoraire", matiere.getVolumeH());

                        it.putExtra("professeur", matiere.getProf());


                        startActivity(it);



                    }

                }) ;

                builder.setNegativeButton("Supprimer", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub

                        dao.deleteMatiere(matiere.getId());

                        List_matieres p = new List_matieres() ;
                        fragmentTransaction = fragmentManager.beginTransaction() ;
                        fragmentTransaction.replace(R.id.sss,p) ;
                        fragmentTransaction.commit() ;




                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });

        butAjoutMatiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* M_Fragment matiereFragment = new M_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,matiereFragment) ;
                fragmentTransaction.commit() ;*/

               startActivity(new Intent(List_matieres.super.getContext(), Add_matiere.class));

            }
        });

        return rootView;
    }

    class MyListAdapter extends ArrayAdapter<Matiere> {



        public   MyListAdapter() {

            super(List_matieres.super.getContext(),R.layout.listview_matiere,matiereArrayList);

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




            ImageView icon = (ImageView) row.findViewById(R.id.iconMat);
             icon.setImageResource(R.mipmap.maticone);


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




}
