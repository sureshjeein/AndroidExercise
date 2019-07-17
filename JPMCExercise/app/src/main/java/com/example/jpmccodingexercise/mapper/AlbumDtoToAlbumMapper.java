package com.example.jpmccodingexercise.mapper;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.data.AlbumDto;

import javax.inject.Inject;

public class AlbumDtoToAlbumMapper implements Mapper<AlbumDto, Album> {

    @Inject
    public AlbumDtoToAlbumMapper() {

    }

    @Override
    public Album map(AlbumDto item) {
        return new Album(item.getUserId(), item.getAlbumId(), item.getTitle());
    }
}
