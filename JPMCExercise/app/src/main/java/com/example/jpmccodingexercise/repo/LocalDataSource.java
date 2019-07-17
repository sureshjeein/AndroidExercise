package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.AlbumEntity;

import java.util.List;

import io.reactivex.Maybe;

public interface LocalDataSource {
    Maybe<List<AlbumEntity>> getAlbums();
    void addAlbums(AlbumEntity... albums);
    void deleteAllAlbums();
}
