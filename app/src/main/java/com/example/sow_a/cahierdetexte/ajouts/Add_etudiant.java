package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;

public class Add_etudiant extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = new DAO(getApplicationContext()) ;


        ajoute = (Button)findViewById(R.id.ajou);

        gr = (RadioGroup)findViewById(R.id.radioGroup2);
        r1 = (RadioButton)findViewById(R.id.radio2);
        r2 = (RadioButton)findViewById(R.id.radio3);

        nom = (EditText)findViewById(R.id.editText1);
        prenom = (EditText)findViewById(R.id.editText2);
        tel = (EditText)findViewById(R.id.editText3);
        email = (EditText)findViewById(R.id.editText4);

        extra = getIntent().getExtras();

        if(extra != null) chargerInfoEtudiant();

        ajoute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                contentValues = new ContentValues() ;


                String p  = prenom.getText().toString();
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
                            getApplicationContext(),
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



                    Toast.makeText(getApplicationContext(),
                            text,
                            Toast.LENGTH_LONG).show();

                    prenom.setText("");
                    nom.setText("");

                    tel.setText("");
                    email.setText("");

                }
            }
        });





        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                this.finish(); ;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
