package com.example.jpmccodingexercise.data;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.jpmccodingexercise.BuildConfig;

@Entity(tableName = BuildConfig.TABLE_NAME, indices = {@Index(value = "title")})
public class AlbumEntity {
    @PrimaryKey(autoGenerate = true)
    private int dbId;
    private final int userId;
    private final int albumId;
    private final String title;

    public AlbumEntity(int dbId, int userId, int albumId, String title) {
        this.dbId = dbId;
        this.userId = userId;
        this.albumId = albumId;
        this.title = title;
    }

    public int getDbId() {
        return dbId;
    }

    public int getUserId() {
        return userId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }
}
