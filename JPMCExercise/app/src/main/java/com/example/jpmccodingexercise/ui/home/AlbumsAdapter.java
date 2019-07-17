package com.example.jpmccodingexercise.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.databinding.ItemAlbumBinding;

import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {

    private final List<Album> albums = new ArrayList<>();

    void setData(List<Album> data) {
        this.albums.clear();
        this.albums.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new AlbumViewHolder(ItemAlbumBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.bind(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private final ItemAlbumBinding itemAlbumBinding;

        AlbumViewHolder(@NonNull ItemAlbumBinding itemAlbumBinding) {
            super(itemAlbumBinding.getRoot());
            this.itemAlbumBinding = itemAlbumBinding;
        }

        void bind(Album album) {
            itemAlbumBinding.setAlbum(album);
            itemAlbumBinding.executePendingBindings();
        }
    }
}
