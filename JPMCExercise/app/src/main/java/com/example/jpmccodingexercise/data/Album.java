package com.example.jpmccodingexercise.data;

public class Album {
    private final int userId;
    private final int albumId;
    private final String title;

    public Album(int userId, int albumId, String title) {
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
