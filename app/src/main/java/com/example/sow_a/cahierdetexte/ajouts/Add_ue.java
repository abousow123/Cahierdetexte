package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;

import java.util.ArrayList;

public class Add_ue extends AppCompatActivity {

    private EditText ue,credits ;
    private Spinner spinnerResponsable ;
    CheckedTextView checkedTextView ;

    MultiAutoCompleteTextView multiMat ;

    ArrayList<String> m ;


    Button button ;
    DAO dao ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<String> selectItems = new ArrayList<>();
        dao = new DAO(getApplicationContext()) ;

        ue = (EditText)findViewById(R.id.unite);
        credits = (EditText)findViewById(R.id.cred) ;
        spinnerResponsable = (Spinner)findViewById(R.id.spinnerResp) ;
        button = (Button)findViewById(R.id.addEU) ;
       multiMat = (MultiAutoCompleteTextView) findViewById(R.id.cr) ;



        ArrayList<String> listProf = new ArrayList<>();
        for (int i = 0;i<dao.allProf().size();i++){
            listProf.add(dao.allProf().get(i).getNom()+ " "+dao.allProf().get(i).getPrenom());
        }

         m = new ArrayList<>();
        for (int i = 0;i<dao.allMatiere().size();i++){
            m.add(dao.allMatiere().get(i).getNom_matiere());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listProf) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerResponsable.setAdapter(dataAdapter);

        ArrayAdapter<String> mult = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,m) ;
        multiMat.setAdapter(mult);
        multiMat.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = ue.getText().toString() ;
                int c = 0;
                   c=Integer.parseInt(credits.getText().toString()) ;
                String resp = spinnerResponsable.getSelectedItem().toString() ;

                String matieres = multiMat.getText().toString() ;


                ContentValues contentValues = new ContentValues() ;

                contentValues.put("nomUE",nom);
                contentValues.put("matieresUE",matieres);
                contentValues.put("creditUE",c);
                contentValues.put("responsableUE",resp);

                dao.addUE(contentValues);
                Toast.makeText(getApplicationContext(),""+c,Toast.LENGTH_LONG).show();



            }
        });


        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

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
