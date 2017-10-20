package com.example.sow_a.cahierdetexte.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.ajouts.Add_ue;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Cour;
import com.example.sow_a.cahierdetexte.metier.ExpandableListAdapte;
import com.example.sow_a.cahierdetexte.metier.Matiere;
import com.example.sow_a.cahierdetexte.metier.Ue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class List_ue extends Fragment {

    Button butAjoutUE;


    ArrayList<Ue> listUE ;

    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;
    ListView listViewtab1,listViewtab3 ;



    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;


    public List_ue() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO(getContext()) ;

        listUE = dao.allUE() ;








        fragmentManager = getFragmentManager() ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_list_ue, container, false);

        // rootView.setOnKeyListener(pressed);





        listViewtab3 = (ListView)rootView.findViewById(R.id.listUE);



        butAjoutUE =  (Button)rootView.findViewById(R.id.butAjoutUE) ;


        ArrayAdapter<Ue> adapter1 = new MyListAdapter1() ;
        listViewtab3.setAdapter(adapter1);









        butAjoutUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* UE_Fragment r = new UE_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,r) ;
                fragmentTransaction.commit() ;*/

               startActivity(new Intent(List_ue.super.getContext(), Add_ue.class));

            }
        });





        return rootView;
    }



    class MyListAdapter1 extends ArrayAdapter<Ue> {



        public   MyListAdapter1() {

            super(List_ue.super.getContext(),R.layout.listview_ue,listUE);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater  lis = getActivity().getLayoutInflater() ;
            View row = lis.inflate(R.layout.listview_ue, parent, false);
            TextView labelnomUE = (TextView) row.findViewById(R.id.nomUE);

            TextView labelCredit =  (TextView) row.findViewById(R.id.cr);
            TextView labelResp =  (TextView) row.findViewById(R.id.Re) ;
            TextView labelMatiere = (TextView)row.findViewById(R.id.mat) ;

            labelnomUE.setText(listUE.get(position).getNomUE());
            labelCredit.setText(""+listUE.get(position).getCreditUE());
            labelResp.setText(listUE.get(position).getResponsable());
            labelMatiere.setText(listUE.get(position).getResponsable());





            return (row);
        }
    }



}
