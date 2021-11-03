package com.example.garciajoaquin_appmusic;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> array_NameSong;
    private ArrayList<String> array_NameAutor;
    private ArrayList<String> array_TotalDuration;

    public RecyclerViewAdapter(ArrayList<String> arraySongs, ArrayList<String> arrayAutors, ArrayList<String> arrayDurations  ){
        array_NameSong = arraySongs;
        array_NameAutor = arrayAutors;
        array_TotalDuration = arrayDurations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tagNameSong.setText(array_NameSong.get(position));
        holder.tagAutorName.setText(array_NameAutor.get(position));
        holder.tagDuration.setText(array_TotalDuration.get(position));
    }

    @Override
    public int getItemCount() {
        return array_NameSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tagNameSong;
        TextView tagAutorName;
        TextView tagDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagNameSong = itemView.findViewById(R.id.itemListSongName);
            tagAutorName = itemView.findViewById(R.id.itemListAutor);
            tagDuration = itemView.findViewById(R.id.itemListSongDuration);

        }
    }
}
