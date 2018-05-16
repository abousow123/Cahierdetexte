package com.example.sow_a.cahierdetexte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.sow_a.cahierdetexte.fragments.ListEtudiant_Fragment;
import com.example.sow_a.cahierdetexte.fragments.ListProf_Fragment;
import com.example.sow_a.cahierdetexte.fragments.List_cours;
import com.example.sow_a.cahierdetexte.fragments.List_matieres;
import com.example.sow_a.cahierdetexte.fragments.List_ue;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    ActionBarDrawerToggle toggle ;
    Bundle bundle ;

    TabHost tabHost;

    FragmentTransaction fragmentTransaction ;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



     //   ViewPager viewPager = (ViewPager)findViewById(R.id.drawer_layout) ;
      //  viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

      //  ImageView imageView = (ImageView)findViewById(R.id.nav_camera) ;


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager() ;

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getFragmentManager().getBackStackEntryCount() == 0) finish();
            }
        });

        List_cours matiereFragment = new List_cours() ;
        fragmentTransaction = fragmentManager.beginTransaction() ;
        fragmentTransaction.replace(R.id.sss,matiereFragment) ;
        fragmentTransaction.commit() ;


      /*  ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);*/




        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getFragmentManager().getBackStackEntryCount() == 0) finish();
            }
        });



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);


        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
           List_cours crs = new List_cours() ;
            fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.sss,crs) ;
            fragmentTransaction.commit() ;
           // setContentView(R.layout.fragment_matiere);
          //  Toast.makeText(getApplicationContext(),"abdxc",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_gallery) {
            List_matieres list_matieres = new List_matieres() ;
            fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.sss,list_matieres) ;
            fragmentTransaction.commit() ;

        } else if (id == R.id.nav_slideshow) {

            List_ue list_ue = new List_ue() ;
            fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.sss,list_ue) ;
            fragmentTransaction.commit() ;

        } else if (id == R.id.nav_manage) {


        } else if (id == R.id.nav_share) {

            ListEtudiant_Fragment listEtudiant_fragment = new ListEtudiant_Fragment() ;
            fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.sss,listEtudiant_fragment) ;
            fragmentTransaction.commit() ;

        } else if (id == R.id.nav_send) {

             ListProf_Fragment listProf_fragment = new ListProf_Fragment() ;
            fragmentTransaction = fragmentManager.beginTransaction() ;
            fragmentTransaction.replace(R.id.sss,listProf_fragment) ;
            fragmentTransaction.commit() ;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
