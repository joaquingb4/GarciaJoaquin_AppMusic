package com.example.garciajoaquin_appmusic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_Fragment extends Fragment {

    ArrayList<String> songs;
    ArrayList<String> autors;
    ArrayList<String> durations;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public List_Fragment() {
        // Required empty public constructor
    }
    public List_Fragment(ArrayList<String> songList, ArrayList<String> autorList, ArrayList<String> durationList){
        this.songs = songList;
        this.autors = autorList;
        this.durations = durationList;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment List_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static List_Fragment newInstance(String param1, String param2) {
        List_Fragment fragment = new List_Fragment();
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

        View view = inflater.inflate(R.layout.fragment_list, container, false);
/*
        songs.add("Dreams");
        songs.add("I just wanna know");
        autors.add("NF");
        autors.add("NF");
        durations.add("30");
        durations.add("30");
*/

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(songs,autors,durations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((view.getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));

        // Inflate the layout for this fragment
        return view;
    }
}