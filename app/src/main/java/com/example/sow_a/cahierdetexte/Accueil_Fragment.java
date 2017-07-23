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

    DAO dao ;
    ListView listView ;


    public Accueil_Fragment() {
        // Required empty public constructor
    }



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
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_accueil_, container, false);

        ArrayAdapter<Matiere> adapter = new MyListAdapter() ;

        listView = (ListView)rootView.findViewById(R.id.listMatiere);

        listView.setAdapter(adapter);

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


}
