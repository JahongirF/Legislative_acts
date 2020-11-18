package com.example.legislative_acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.LayoutAnimationController;

import com.example.legislative_acts.Adapter.Acts_Adapter;
import com.example.legislative_acts.Data.Acts_Subtitle;
import com.example.legislative_acts.Fragment.About_Activity_Fragment;
import com.example.legislative_acts.Fragment.Fragment_Main_Activity;
import com.example.legislative_acts.Fragment.Other_Activity_Fragment;
import com.example.legislative_acts.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        switch (id) {
            case R.id.darkMode:
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPreferences.edit().putString("darkMode","no").apply();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPreferences.edit().putString("darkMode","yes").apply();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String dark = sharedPreferences.getString("darkMode","no");
        if (dark.equals("no"))
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }


        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.open, R.string.close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Main_Activity()).commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_activity:
                getSupportFragmentManager().beginTransaction().addToBackStack("main").replace(R.id.fragment_container, new Fragment_Main_Activity()).commit();
                break;

            case R.id.about_activity:
                getSupportFragmentManager().beginTransaction().addToBackStack("about").replace(R.id.fragment_container, new About_Activity_Fragment()).commit();

                break;

            case R.id.other_activity:
                getSupportFragmentManager().beginTransaction().addToBackStack("other").replace(R.id.fragment_container, new Other_Activity_Fragment()).commit();
                break;


            case R.id.share_activity:
                try {
                    PackageManager pm = this.getPackageManager();
                    ApplicationInfo ai = pm.getApplicationInfo(this.getPackageName(), 0);
                    File srcFile = new File(ai.publicSourceDir);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("*/*");
                    intent.putExtra(
                            Intent.EXTRA_TEXT,
                            "James"
                    );
                    Uri uri = FileProvider.getUriForFile(this, this.getPackageName(), srcFile);
                    intent.putExtra(Intent.EXTRA_STREAM, uri);
                    this.grantUriPermission(
                            this.getPackageManager().toString(),
                            uri,
                            (Intent.FLAG_GRANT_WRITE_URI_PERMISSION + Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    );
                    this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.facebook_activity:
                Uri uri = Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/moliya.studiyasi/");
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Выберите нужное вам приложение"));
                break;

            case R.id.instagramm_activity:
                Uri uri1 = Uri.parse("https://www.instagram.com/moliya_studiyasi/");
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri1), "Выберите нужное вам приложение"));
                break;

            case R.id.telegramm_activity:
                Uri uri2 = Uri.parse("https://tmtr.me/moliya_studiyasi");
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri2), "Выберите нужное вам приложение"));
                break;


        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}