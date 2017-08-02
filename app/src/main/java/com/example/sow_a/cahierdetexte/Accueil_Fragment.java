package com.example.sow_a.cahierdetexte;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;


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
        ArrayAdapter<String> adapter1 = new MyListAdapter1() ;
        ArrayAdapter<String> adapter2 = new MyListAdapter2() ;

        listViewtab1 = (ListView)rootView.findViewById(R.id.listMatiere);
        listViewtab2 = (ListView)rootView.findViewById(R.id.list_cour);
        listViewtab2_suite = (ListView)rootView.findViewById(R.id.list_cour2) ;



        listViewtab1.setAdapter(adapter);

        listViewtab2.setAdapter(adapter1);
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


    class MyListAdapter1 extends ArrayAdapter<String> {



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

         /*  ImageView icon = (ImageView) row.findViewById(R.id.icon);

            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Femme"))
                icon.setImageResource(R.drawable.f1);
            if (etudiants.get(position).getSexe()
                    .equalsIgnoreCase("Homme"))
                icon.setImageResource(R.drawable.h1);*/

            return (row);
        }
    }


    class MyListAdapter2 extends ArrayAdapter<String> {



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

         /*  ImageView icon = (ImageView) row.findViewById(R.id.icon);

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
