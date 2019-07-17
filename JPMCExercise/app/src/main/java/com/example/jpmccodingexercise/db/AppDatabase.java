package com.example.jpmccodingexercise.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jpmccodingexercise.BuildConfig;
import com.example.jpmccodingexercise.data.AlbumEntity;

@Database(entities = AlbumEntity.class, version = BuildConfig.DATABASE_VERSION)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlbumsDao albumsDao();
}
