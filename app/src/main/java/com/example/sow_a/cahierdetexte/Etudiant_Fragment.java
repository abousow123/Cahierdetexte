package com.example.sow_a.cahierdetexte;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Etudiant_Fragment extends Fragment {

    private EditText prenom;
    private EditText nom;
    private EditText tel;
    private EditText email;
    private Button ajoute;

    RadioGroup gr ;
    RadioButton r1, r2;

    DAO dao ;
    ContentValues contentValues ;
    Bundle extra ;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;


    public Etudiant_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO(getContext()) ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_etudiant_, container, false);

        ajoute = (Button)view.findViewById(R.id.ajou);

        gr = (RadioGroup)view.findViewById(R.id.radioGroup2);
        r1 = (RadioButton)view.findViewById(R.id.radio2);
        r2 = (RadioButton)view.findViewById(R.id.radio3);

        nom = (EditText)view.findViewById(R.id.editText1);
        prenom = (EditText)view.findViewById(R.id.editText2);
        tel = (EditText)view.findViewById(R.id.editText3);
        email = (EditText)view.findViewById(R.id.editText4);

       extra = getArguments();

        if(extra != null) chargerInfoEtudiant();

        ajoute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                contentValues = new ContentValues() ;

                String p = prenom.getText().toString();
                String n = nom.getText().toString();
                String telephone = tel.getText().toString();
                String e = email.getText().toString();

                String sexe = "";
                if (r1.isChecked())
                    sexe = "Femme";
                if (r2.isChecked())
                    sexe = "Homme";

                if (n.equalsIgnoreCase("") || p.equalsIgnoreCase("")
                        || telephone.equalsIgnoreCase("") || e.equalsIgnoreCase("")) {

                    Toast.makeText(
                            getContext(),
                            "Veuillez entrer tout les informations s'il vous plait !!!",
                            Toast.LENGTH_LONG).show();

                }
                else {

                    contentValues.put("nom",n);
                    contentValues.put("prenom",p);
                    contentValues.put("sexe",sexe);
                    contentValues.put("telephone",telephone);
                    contentValues.put("email",e);



                    String text = "";

                    if(extra == null) {
                        dao.addEtudiant(contentValues);
                        text = n +", Ajouter avec succés !!!";
                    }
                   else {
                        dao.updateEtudiant(contentValues, extra.getInt("idEtudiant"));
                        text= "Mofication effectué avec succès";
                    }



                    Toast.makeText(getContext(),
                            text,
                            Toast.LENGTH_LONG).show();

                    prenom.setText("");
                    nom.setText("");

                    tel.setText("");
                    email.setText("");

                }
            }
        });

        return view ;
    }

    public void chargerInfoEtudiant() {
        this.nom.setText(extra.getString("nom"));
        this.prenom.setText(extra.getString("prenom"));
        this.tel.setText(String.valueOf(extra.getInt("telephone")));
        this.email.setText(extra.getString("email"));
        if(extra.getString("sexe").equalsIgnoreCase("Femme") )
            r1.setChecked(true);
        if(extra.getString("sexe").equalsIgnoreCase("Homme") )
            r2.setChecked(true);
    }


}
