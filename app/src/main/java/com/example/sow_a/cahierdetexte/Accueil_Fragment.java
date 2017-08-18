package com.example.sow_a.cahierdetexte;


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

    Button butAjoutMatiere,butAjoutUE, butAjoutCour  ;

    ArrayList<Matiere> matiereArrayList ;
    ArrayList<Cour> cours ;
    ArrayList<Ue> listUE ;

    ArrayList<String> ab;
    ArrayList<String> ab1;

    DAO dao ;
    ListView listViewtab1,listViewtab3 ;

    ExpandableListAdapte listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;


    public Accueil_Fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAO(getContext()) ;
        matiereArrayList = dao.allMatiere() ;
        listUE = dao.allUE() ;
        cours = dao.allCour() ;

        fragmentManager = getFragmentManager() ;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_accueil_, container, false);

        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;


        listViewtab1 = (ListView)rootView.findViewById(R.id.listMatiere);
        listViewtab3 = (ListView)rootView.findViewById(R.id.listUE);
        expListView = (ExpandableListView)rootView.findViewById(R.id.listExpandable);

        butAjoutMatiere = (Button)rootView.findViewById(R.id.butAjoutMatiere) ;
        butAjoutUE =  (Button)rootView.findViewById(R.id.butAjoutUE) ;
        butAjoutCour = (Button)rootView.findViewById(R.id.butAjoutCour) ;

        ArrayAdapter<Ue> adapter1 = new MyListAdapter1() ;
        listViewtab3.setAdapter(adapter1);





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

        butAjoutMatiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                M_Fragment matiereFragment = new M_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,matiereFragment) ;
                fragmentTransaction.commit() ;

            }
        });

        butAjoutUE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UE_Fragment r = new UE_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,r) ;
                fragmentTransaction.commit() ;

            }
        });

        butAjoutCour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C_Fragment c = new C_Fragment() ;
                fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.sss,c) ;
                fragmentTransaction.commit() ;

            }
        });

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapte(Accueil_Fragment.super.getContext(),listDataHeader,listDataChild) ;

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){

            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                final Cour cour = cours.get(i) ;

                AlertDialog.Builder buider = new AlertDialog.Builder(getContext()) ;

                buider.setMessage(cour.toString());

                AlertDialog dialog = buider.create();
                dialog.show();

                return false;
            }
        });








         String a= "no" ;





        TabHost host = (TabHost)rootView.findViewById(R.id.tabHost);
        host.setup();


        //Tab 2
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Cours");
        a = spec.getTag() ;
        host.addTab(spec);

        //Tab 1
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Matière");
        host.addTab(spec);



        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Unités d'enseignement");
        host.addTab(spec);

        Toast.makeText(getContext(),a,Toast.LENGTH_LONG).show();

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


   class MyListAdapter1 extends ArrayAdapter<Ue> {



        public   MyListAdapter1() {

            super(Accueil_Fragment.super.getContext(),R.layout.listview_ue,listUE);

        }

        public void onClick(View view) {

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater  lis = getActivity().getLayoutInflater() ;
            View row = lis.inflate(R.layout.listview_ue, parent, false);
            TextView labelnomUE = (TextView) row.findViewById(R.id.nomUE);
            TextView labelCredit =  (TextView) row.findViewById(R.id.credit1);
            TextView labelResp =  (TextView) row.findViewById(R.id.Resp) ;

            labelnomUE.setText(listUE.get(position).getNomUE());
           labelCredit.setText(""+listUE.get(position).getCreditUE());
            labelResp.setText(listUE.get(position).getResponsable());





            return (row);
        }
    }


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


      //  dao = new DAO() ;

        List<String> li = new ArrayList<String>();

        for (int i = 0;i<dao.allCour().size();i++){
            listDataHeader.add(dao.allCour().get(i).getDate());


        }
        int k = 0 ;
        while (k<=dao.allCour().size()-1){
            List<String> l = new ArrayList<String>();



            for (int i = 0;i<dao.allCour().size();i++){
                l.add(dao.allCour().get(i).getMatiere()) ;

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
