package com.example.sow_a.cahierdetexte.fragments;


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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.ajouts.Add_ue;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Ue;

import java.util.ArrayList;


public class List_ue extends Fragment {

    Button butAjoutUE;


    ArrayList<Ue> listUE ;

    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;
    ListView listViewtab3 ;



    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;


    public List_ue() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO(getContext()) ;
         listUE = new ArrayList<>() ;
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

        if(listUE.size()!=0)
            Toast.makeText(getContext(), listUE.get(0).getResponsable(), Toast.LENGTH_LONG).show();


        String[] a = new String[3] ;

       // for (int i = 0;i<dao.allUE().size();i++){

        //    a[i] = dao.allUE().get(i).getNomUE() ;

       // }

        a[0]= "xsvx" ;


        ArrayAdapter<Ue> adapter1 = new MyListAdapter1() ;
                //MyListAdapter1() ;
        listViewtab3.setAdapter(adapter1);

        listViewtab3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                final AlertDialog.Builder builder = new AlertDialog.Builder(
                        getContext());

                builder.setMessage("fdfcxcx");



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });



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


            TextView labelnomUE = (TextView) row.findViewById(R.id.nomEU);



            TextView labelCredit =  (TextView) row.findViewById(R.id.cr);
            TextView labelResp =  (TextView) row.findViewById(R.id.re) ;
            TextView labelMatiere = (TextView)row.findViewById(R.id.mat) ;


            String[] sepa = listUE.get(position).getMatieres().split(", ") ;

            labelnomUE.setText(listUE.get(position).getNomUE());
            labelCredit.setText(""+listUE.get(position).getCreditUE());
            labelResp.setText(listUE.get(position).getResponsable());
            labelMatiere.setText(sepa[0]);

          /*  if(sepa.length==1) labelMatiere.setText(sepa[0]);
            if(sepa.length==2){
                labelMatiere.setText(sepa[0]);
                labelMat2.setText(sepa[1]);
            }
            if(sepa.length==3){
                labelMatiere.setText(sepa[0]);
                labelMat2.setText(sepa[1]);
                labelMat3.setText(sepa[2]);
            }*/






            return (row);
        }
    }



}
