package com.nav.anothernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // NavController navController = NavHostFragment.findNavController(new aboutUsFragment());
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                //.setDrawerLayout(drawerLayout) is deprecated
                .setOpenableLayout(drawerLayout)
                .build();


        /*---in general, when adding navigation support to the default actionbar, you'd need to
        i. call NavigationUI.setupActionBarWithNavController() in onCreate()
        ii. then override onSupportNavigateUp()---*/

        /*Connects the actionbar to the navController*/
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        /*Connects the navigationView to the navController, so that clicking on navigation view items
        links to the appropriate destination*/
        NavigationUI.setupWithNavController(navigationView, navController);


        /* When using a custom toolbar and not the default actionbar, setup up the toolbar with the
         navigation controller as follows: */
        // NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }


    /*------without overriding this method, the drawer and back icons don't work-----*/
    /*---when using the appbar with the navigation component,
    as in NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);,
     you have to override onSupportNavigateUP() to handle up navigation*/
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

}
