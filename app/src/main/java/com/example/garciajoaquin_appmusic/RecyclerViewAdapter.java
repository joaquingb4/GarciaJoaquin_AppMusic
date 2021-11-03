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

    public RecyclerViewAdapter(ArrayList<String> arrN){
        array_NameSong = arrN;
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
    }

    @Override
    public int getItemCount() {
        return array_NameSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tagNameSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagNameSong = itemView.findViewById(R.id.itemListUserName);
        }
    }
}
