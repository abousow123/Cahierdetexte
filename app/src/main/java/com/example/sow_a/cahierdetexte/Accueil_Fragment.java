package com.example.sow_a.cahierdetexte;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Accueil_Fragment extends Fragment {

    TabHost tabHost;

    ArrayList<Matiere> matiereArrayList ;

    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;
    ListView listViewtab1,listViewtab2,listViewtab2_suite ;

    ExpandableListAdapte listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    public Accueil_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO() ;
        matiereArrayList = dao.allMatiere(getContext()) ;
        //  listView = (ListView)getView()findViewById(R.id.listMatiere); ;

        ab = new ArrayList<String>();
        ab.add("acd");
        ab.add("gbv");
        ab.add("bnn");
        ab.add("bnbn");

        ab1 = new ArrayList<String>();
        ab1.add("gfbnhvbvn");
        ab1.add("vghbvnbn");
        ab1.add("nv,bjgjh");
        ab1.add("bvhghhvvh");



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_accueil_, container, false);

        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;
       /* ArrayAdapter<String> adapter1 = new MyListAdapter1() ;
        ArrayAdapter<String> adapter2 = new MyListAdapter2() ;*/

        listViewtab1 = (ListView)rootView.findViewById(R.id.listMatiere);
        expListView = (ExpandableListView)rootView.findViewById(R.id.listExpandable);
      //  listViewtab2_suite = (ListView)rootView.findViewById(R.id.list_cour2) ;





        listViewtab1.setAdapter(adapter);

        listViewtab1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Matiere matiere = matiereArrayList.get(i) ;

                AlertDialog.Builder buider = new AlertDialog.Builder(getContext()) ;

                buider.setMessage(matiere.toString());

                AlertDialog dialog = buider.create();
                dialog.show();


            }
        });

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapte(Accueil_Fragment.super.getContext(),listDataHeader,listDataChild) ;

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder buider = new AlertDialog.Builder(getContext()) ;

                buider.setMessage("abdsd");

                AlertDialog dialog = buider.create();
                dialog.show();


            }
        });



  //      listViewtab2.setAdapter(adapter1);
//        listViewtab2_suite.setAdapter(adapter2);

        TabHost host = (TabHost)rootView.findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Matière");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Cours");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Professeur");
        host.addTab(spec);


        return rootView;
    }

    class MyListAdapter extends ArrayAdapter<Matiere> {



        public   MyListAdapter() {

            super(Accueil_Fragment.super.getContext(),R.layout.listview_matiere,matiereArrayList);

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


  /* class MyListAdapter1 extends ArrayAdapter<String> {



        public   MyListAdapter1() {

            super(Accueil_Fragment.super.getContext(),R.layout.listview_cour,ab);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater  lis = getActivity().getLayoutInflater() ;
            View row = lis.inflate(R.layout.listview_cour, parent, false);
            TextView label = (TextView) row.findViewById(R.id.textcour1);
            //triTabChaine(sg);
            label.setText(ab.get(position));

           ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);

            return (row);
        }
    }*/


   /* class MyListAdapter2 extends ArrayAdapter<String> {



        public   MyListAdapter2() {

            super(Accueil_Fragment.super.getContext(),R.layout.listview_cour_suite,ab1);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater  lis = getActivity().getLayoutInflater() ;
            View row = lis.inflate(R.layout.listview_cour_suite, parent, false);
            TextView label = (TextView) row.findViewById(R.id.te1);
            //triTabChaine(sg);
            label.setText(ab1.get(position) );

           ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);

            return (row);
        }
    }*/


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
      /*  listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");*/


        dao = new DAO() ;

        List<String> li = new ArrayList<String>();

        for (int i = 0;i<dao.allCour(getContext()).size();i++){
            listDataHeader.add(dao.allCour(getContext()).get(i).getDate());


        }
        int k = 0 ;
        while (k<=dao.allCour(getContext()).size()-1){
            List<String> l = new ArrayList<String>();



            for (int i = 0;i<dao.allCour(getContext()).size();i++){
                l.add(dao.allCour(getContext()).get(i).getHeureDeb()) ;

            }



            listDataChild.put(listDataHeader.get(k), l);

            k++ ;

        }






        // Adding child data
    /*    List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
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
        comingSoon.add("Europa Report");*/

      /*  listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3),li) ;*/
    }








}
