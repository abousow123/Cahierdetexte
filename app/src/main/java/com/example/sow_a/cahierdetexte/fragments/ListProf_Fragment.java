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
import com.example.sow_a.cahierdetexte.ajouts.Add_professeur;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Professeur;

import java.util.ArrayList;


public class ListProf_Fragment extends Fragment {

    ListView listView;
    ImageView iconne, ic ;

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

        iconne.setImageResource(R.mipmap.ab);
        iconne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               /* Prof_Fragment prof_fragment = new Prof_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,prof_fragment) ;
                fragmentTransaction.commit() ;*/

               startActivity(new Intent(ListProf_Fragment.super.getContext(), Add_professeur.class));


            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                final Professeur pr = professeurs.get(arg2);

                final AlertDialog.Builder builder = new AlertDialog.Builder(
                        getContext());

                builder.setMessage(pr.toString());

                builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // ContentValues cv = new ContentValues() ;


                      /*  Intent it = new Intent(MainActivity.this,Ajout.class);

                        it.putExtra("id",etd.getId());
                        it.putExtra("nom", etd.getNom());
                        it.putExtra("prenom", etd.getPrenom());
                        it.putExtra("age", etd.getAge());
                        it.putExtra("sexe", etd.getSexe());
                        it.putExtra("email",etd.getEmail());

                        startActivity(it);

                        Etudiant_Fragment etudiant_fragment = new Etudiant_Fragment() ;
                        Bundle bundle = new Bundle() ;
                        bundle.putInt("idEtudiant",etd.getId());
                        bundle.putString("nom", etd.getNom());
                        bundle.putString("prenom", etd.getPrenom());
                        bundle.putString("sexe", etd.getSexe());
                        bundle.putInt("telephone", etd.getTelephone());
                        bundle.putString("email", etd.getEmail());

                        etudiant_fragment.setArguments(bundle);
                        fragmentTransaction = fragmentManager.beginTransaction() ;
                        fragmentTransaction.replace(R.id.sss,etudiant_fragment) ;
                        fragmentTransaction.commit() ;*/



                    }

                }) ;

                builder.setNegativeButton("Supprimer", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub

                        dao.deleteProf(pr.getId());

                        ListProf_Fragment p = new ListProf_Fragment() ;
                        fragmentTransaction = fragmentManager.beginTransaction() ;
                        fragmentTransaction.replace(R.id.sss,p) ;
                        fragmentTransaction.commit() ;




                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });



        return view ;
    }



    class MyListAdapter extends ArrayAdapter<Professeur> {
        MyListAdapter() {

            super(ListProf_Fragment.super.getContext(), R.layout.listeprof_suit,professeurs);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.listeprof_suit, parent, false);
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

         ImageView   ic = (ImageView)row.findViewById(R.id.iconn) ;
           ic.setImageResource(R.mipmap.prof);
            return (row);
        }
    }



}






