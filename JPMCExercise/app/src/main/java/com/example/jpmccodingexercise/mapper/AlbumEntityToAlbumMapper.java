package com.example.jpmccodingexercise.mapper;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.data.AlbumEntity;

import javax.inject.Inject;

public class AlbumEntityToAlbumMapper implements Mapper<AlbumEntity, Album> {

    @Inject
    public AlbumEntityToAlbumMapper() {
    }

    @Override
    public Album map(AlbumEntity item) {
        return new Album(item.getUserId(), item.getAlbumId(), item.getTitle());
    }
}
