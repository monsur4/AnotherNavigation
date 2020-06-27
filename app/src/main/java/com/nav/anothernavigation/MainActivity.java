package com.nav.anothernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
                //.setDrawerLayout(drawerLayout)
                .setOpenableLayout(drawerLayout)
                .build();

        // NavigationUI.setupWithNavController(navigationView, navController); --> doesn't show drawer icon

        /*---both methods below show the drawer icon, but without the onSupportNavigateUpMethod, the icon doesn't click*/
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); ==> works
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        // navigationView.setupWithNavController(, navController);
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


    /*------without adding this method, the drawer and back icons don't work-----*/
    @Override
    public boolean onSupportNavigateUp() {
        // the arrow back button works but the drawer icon button doesn't work
        // return navController.navigateUp();

        // both the arrow back and the drawer icon buttons work
        return NavigationUI.navigateUp(navController, drawerLayout);
    }

}
