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
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.ajouts.Add_Cours;
import com.example.sow_a.cahierdetexte.dao.DAO;
import com.example.sow_a.cahierdetexte.metier.Cour;
import com.example.sow_a.cahierdetexte.metier.ExpandableListAdapte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class List_cours extends Fragment {

  //  Button butAjoutCour  ;


    ArrayList<Cour> cours ;


    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;


    ExpandableListAdapte listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;

    public List_cours() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        dao = new DAO(getContext()) ;

        cours = dao.allCour() ;



        fragmentManager = getFragmentManager() ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_list_cours, container, false);

        // rootView.setOnKeyListener(pressed);






        expListView = (ExpandableListView)rootView.findViewById(R.id.listExpandable);


       // butAjoutCour = (Button)rootView.findViewById(R.id.butAjoutCour) ;












        ImageView fab = (ImageView) rootView.findViewById(R.id.fab);
        fab.setImageResource(R.mipmap.addcours);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(List_cours.super.getContext(), Add_Cours.class));
            }
        });

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapte(List_cours.super.getContext(),listDataHeader,listDataChild) ;

        // setting list adapter
        expListView.setAdapter(listAdapter);



        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){

            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                final Cour cour = cours.get(i) ;

                AlertDialog.Builder buider = new AlertDialog.Builder(getContext()) ;

                buider.setMessage(cour.toString());

               // Toast.makeText(getContext(),"sdsds",Toast.LENGTH_LONG).show();

                AlertDialog dialog = buider.create();
                dialog.show();

                return false;
            }
        });





        return rootView;
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
      // listDataHeader.add("Top 250");
       // listDataHeader.add("Now Showing");
       // listDataHeader.add("Coming Soon..");




        // dao = new DAO(getContext()) ;

     // Toast.makeText(getContext(),dao.allCour().get(0).getDescription(),Toast.LENGTH_LONG).show();

        if(dao.allCour().size()!=0) {
            listDataHeader.add(dao.allCour().get(0).getDate());
            for (int i = 1; i < dao.allCour().size(); i++) {
                if (dao.allCour().get(i - 1).getDate().equalsIgnoreCase(dao.allCour().get(i).getDate()))
                    listDataHeader.add(dao.allCour().get(i).getDate());

            }

            int k = 0;

            while (k < listDataHeader.size()) {
                ArrayList<String> li = new ArrayList<>();
                for (int i = 0; i < dao.allCour().size(); i++) {
                    if (dao.allCour().get(i).getDate().equalsIgnoreCase(listDataHeader.get(k))) {
                        li.add(dao.allCour().get(i).getMatiere());
                    }

                }
                listDataChild.put(listDataHeader.get(k), li);
                k++;
            }


        }





       /* for (int i = 0;i<dao.allCour().size();i++){
            if(dao.allCour().get(i).getDate().equalsIgnoreCase(listDataHeader.get(i))){
                  li.add(dao.allCour().get(i).getMatiere()) ;

            }

            listDataChild.put(listDataHeader.get(i),li) ;

        }







        // Adding child data
      List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

     /*   List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

    //   listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
       // listDataChild.put(listDataHeader.get(1), nowShowing);
      //  listDataChild.put(listDataHeader.get(2), comingSoon);
        //listDataChild.put(listDataHeader.get(3),li) ;
       for (int i = 0;i<dao.allCour().size();i++){
            listDataChild.put(listDataHeader.get(i),top250) ;

        }*/
    }








}
