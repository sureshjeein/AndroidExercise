package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.Album;

import java.util.List;

import io.reactivex.Observable;

public interface AlbumsRepository {
    Observable<List<Album>> getSortedAlbums(boolean isAscending);
}
