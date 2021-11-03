package com.example.garciajoaquin_appmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    //Attributes
    private static ArrayList<String> array_songs = new ArrayList<String>();
    private static ArrayList<String> array_autors = new ArrayList<String>();
    private static ArrayList<String> array_durations = new ArrayList<String>();;

    public static void addData (String song, String autor, String duration ){
        array_songs.add(song);
        array_autors.add(autor);
        array_durations.add(duration);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner, new Home_Fragment()).commit();
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new Home_Fragment();
                    break;
                case R.id.nav_list:
                    selectedFragment = new List_Fragment(array_songs, array_autors, array_durations);
                    break;
                case R.id.nav_form:
                    selectedFragment = new Form_Fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner, selectedFragment).commit();
            return true;
        });


    }
}