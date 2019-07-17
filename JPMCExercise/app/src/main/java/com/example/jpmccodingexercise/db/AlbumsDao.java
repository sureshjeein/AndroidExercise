package com.example.jpmccodingexercise.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.jpmccodingexercise.data.AlbumEntity;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface AlbumsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbum(AlbumEntity... albumEntities);

    @Query("SELECT * FROM albums")
    Maybe<List<AlbumEntity>> getAlbums();

    @Query("DELETE FROM albums")
    void deleteAllAlbums();
}
