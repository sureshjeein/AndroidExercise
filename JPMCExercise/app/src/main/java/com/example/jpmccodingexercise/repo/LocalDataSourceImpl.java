package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.AlbumEntity;
import com.example.jpmccodingexercise.db.AppDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class LocalDataSourceImpl implements LocalDataSource {


    private final AppDatabase appDatabase;

    @Inject
    public LocalDataSourceImpl(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Maybe<List<AlbumEntity>> getAlbums() {
        return appDatabase.albumsDao().getAlbums();
    }

    @Override
    public void addAlbums(AlbumEntity... albumEntities) {
        appDatabase.albumsDao().insertAlbum(albumEntities);
    }

    @Override
    public void deleteAllAlbums() {
        appDatabase.albumsDao().deleteAllAlbums();
    }
}
