package com.example.sow_a.cahierdetexte.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.ajouts.Add_etudiant;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Etudiant;

import java.util.ArrayList;


public class ListEtudiant_Fragment extends Fragment {

    ListView listView;
    ImageView iconne;
    private SearchView recherche;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;

//	private AutoCompleteTextView autoCompleteTextView;
    //String sg[] ;

    DAO dao ;
    ArrayList<Etudiant> etudiants ;

    ArrayAdapter<Etudiant> adapter ;


    public ListEtudiant_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO(getContext());
        etudiants = dao.allEtudiants() ;
        fragmentManager = getFragmentManager() ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_list_etudiant_, container, false);
        listView = (ListView)view.findViewById(R.id.listView1);

        iconne = (ImageView)view.findViewById(R.id.button1);

         adapter = new MyListAdapter() ;

        listView.setAdapter(adapter);
       // fragmentManager = getArguments() ;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                final Etudiant etd = etudiants.get(arg2);

                final AlertDialog.Builder builder = new AlertDialog.Builder(
                        getContext());

                builder.setMessage(etd.toString());

                builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent it = new Intent(ListEtudiant_Fragment.super.getContext(),Add_etudiant.class) ;


                  ;


                        it.putExtra("idEtudiant",etd.getId());
                        it.putExtra("nom", etd.getNom());
                        it.putExtra("prenom", etd.getPrenom());

                        it.putExtra("sexe", etd.getSexe());
                        it.putExtra("telephone", etd.getTelephone());
                        it.putExtra("email",etd.getEmail());

                        startActivity(it);






                    }

                }) ;

                builder.setNegativeButton("Supprimer", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub

                        dao.deleteEtudiant(etd.getId());

                        adapter.notifyDataSetChanged();

                         ListEtudiant_Fragment l = new ListEtudiant_Fragment() ;
                        fragmentTransaction = fragmentManager.beginTransaction() ;
                        fragmentTransaction.replace(R.id.sss,l) ;
                        fragmentTransaction.commit() ;



             //           listView.setAdapter(adapter);


                       /* Toast.makeText(getApplicationContext(),
                                "Etudiant Supprimer avec succés !!!",
                                Toast.LENGTH_LONG).show();*/

                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });

        iconne.setImageResource(R.mipmap.ab);

        iconne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
              /*  Etudiant_Fragment etudiant_fragment = new Etudiant_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,etudiant_fragment) ;
                fragmentTransaction.commit() ;*/

              startActivity(new Intent(ListEtudiant_Fragment.super.getContext(), Add_etudiant.class));


            }
        });

        return view ;
    }


    class MyListAdapter extends ArrayAdapter<Etudiant> {
        MyListAdapter() {

            super(ListEtudiant_Fragment.super.getContext(), R.layout.listetudiant_suit,etudiants);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.listetudiant_suit, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textView1);
            //triTabChaine(sg);
            label.setText(etudiants.get(position).getPrenom() + " "
                    + etudiants.get(position).getNom());

            ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.mipmap.sf);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.mipmap.sh);

            return (row);
        }
    }



}
