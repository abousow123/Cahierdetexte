package com.example.sow_a.cahierdetexte.ajouts;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sow_a.cahierdetexte.R;
import com.example.sow_a.cahierdetexte.dao.DAO;

import java.util.ArrayList;

public class Add_ue extends AppCompatActivity {

    private EditText ue,credits ;
    private Spinner spinner ;
    CheckedTextView checkedTextView ;


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
        spinner = (Spinner)findViewById(R.id.spinnerResp) ;
        button = (Button)findViewById(R.id.addEU) ;
       // checkedTextView = (CheckedTextView) findViewById(R.id.cr) ;
        ListView listView = (ListView) findViewById(R.id.cr) ;
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayList<String> ms = new ArrayList<>();
        for (int i = 0;i<dao.allProf().size();i++){
            ms.add(dao.allProf().get(i).getNom()+ " "+dao.allProf().get(i).getPrenom());
        }

        ArrayList<String> m = new ArrayList<>();
        for (int i = 0;i<dao.allProf().size();i++){
            m.add(dao.allMatiere().get(i).getNom_matiere());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ms) ;

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> data = new ArrayAdapter<String>(getApplicationContext(),R.layout.checktex, m) ;
        listView.setAdapter(data);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectItem = ((TextView)view).getText().toString() ;

                if(selectItems.contains(selectItem)){
                    selectItems.remove(selectItem) ;
                }
                else {
                    selectItems.add(selectItem) ;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ue.getText().toString() ;
                int c = Integer.parseInt(credits.getText().toString()) ;
                String resp = spinner.getSelectedItem().toString() ;

                String ma = "" ;
                for (String m: selectItems){
                     ma += m+"\n" ;
                }

                ContentValues contentValues = new ContentValues() ;

                contentValues.put("nomUE",n);
                contentValues.put("matieresUE",ma);
                contentValues.put("creditUE",c);
                contentValues.put("responsableUE",resp);

                dao.addUE(contentValues);
                Toast.makeText(getApplicationContext(),"succés",Toast.LENGTH_LONG).show();

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
