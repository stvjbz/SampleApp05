package com.stvjbz.sampleapp05.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.stvjbz.sampleapp05.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final String[] fragments = {
            "com.stvjbz.sampleapp05.fragment.MysizeGragment",
            "com.stvjbz.sampleapp05.fragment.PropertyFragment",
            "com.stvjbz.sampleapp05.fragment.MemorialFragment",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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


    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (id) {
            case R.id.nav_mysize:
                //Toast.makeText(this, "MysizeFragment", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[0]))
                        .commit();
                break;
            case R.id.nav_property:
                //Toast.makeText(this, "MysizeFragment", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[1]))
                        .commit();
                break;
            case R.id.nav_memorial:
                //Toast.makeText(this, "MysizeFragment", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[2]))
                        .commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
