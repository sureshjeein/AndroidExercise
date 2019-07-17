package com.example.jpmccodingexercise.data;

import com.squareup.moshi.Json;

public class AlbumDto {
    private final int userId;
    @Json(name = "id")
    private final int albumId;
    private final String title;

    public AlbumDto(int userId, int albumId, String title) {
        this.userId = userId;
        this.albumId = albumId;
        this.title = title;
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
