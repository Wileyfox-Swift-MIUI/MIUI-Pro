package lordhmen.miui.pro;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        getSupportActionBar().setTitle(R.string.information);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager.beginTransaction()
                .replace(R.id.content_main, new InformationFragment())
                .commit();


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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()) {
            case R.id.information:
                getSupportActionBar().setTitle(getResources().getString(R.string.information));
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, new InformationFragment())
                        .commit();
                break;
            case R.id.email:
                getSupportActionBar().setTitle(getResources().getString(R.string.writedeveloper));
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, new EmailFragment())
                        .commit();
                break;
            case R.id.features_pro:
                getSupportActionBar().setTitle(getResources().getString(R.string.features_pro));
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, new Features_pro())
                        .commit();
                break;
            case R.id.about:
                getSupportActionBar().setTitle(getResources().getString(R.string.about));
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, new AboutApp())
                        .commit();
                break;
            case R.id.pro_version_instructions:
                getSupportActionBar().setTitle(getResources().getString(R.string.pro_version_instructions));
                fragmentManager.beginTransaction()
                        .replace(R.id.content_main, new ProInstructions())
                        .commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
