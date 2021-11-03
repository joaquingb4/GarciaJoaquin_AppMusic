package com.example.garciajoaquin_appmusic;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import DB.SongsDBHelper;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Form_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Form_Fragment extends Fragment {

    private SongsDBHelper dbHelper;
    private SQLiteDatabase db;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Form_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Form_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Form_Fragment newInstance(String param1, String param2) {
        Form_Fragment fragment = new Form_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_, container, false);
        //Login to save the information
        Button btnSave = view.findViewById(R.id.btnRecord);
        // fields to save
        EditText songName = view.findViewById(R.id.txtSongName);
        EditText autor = view.findViewById(R.id.txtAutorName);
        EditText duration = view.findViewById(R.id.txtDurationSong);

        dbHelper = new SongsDBHelper(getActivity().getApplicationContext()); //To research
        db = dbHelper.getWritableDatabase();


        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Song s = new Song(songName.getText().toString()
                    ,autor.getText().toString(),
                        duration.getText().toString()
                );
                dbHelper.insertContact(db, s );


                MenuActivity.addData(songName.getText().toString(), autor.getText().toString(), duration.getText().toString());
            }
        });



        // Inflate the layout for this fragment
        return view;
    }


}