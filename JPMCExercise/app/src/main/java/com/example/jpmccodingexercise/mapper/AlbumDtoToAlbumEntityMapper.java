package com.example.jpmccodingexercise.mapper;

import com.example.jpmccodingexercise.data.AlbumDto;
import com.example.jpmccodingexercise.data.AlbumEntity;

import javax.inject.Inject;

public class AlbumDtoToAlbumEntityMapper implements Mapper<AlbumDto, AlbumEntity> {

    @Inject
    public AlbumDtoToAlbumEntityMapper() {
    }

    @Override
    public AlbumEntity map(AlbumDto item) {
        return new AlbumEntity(0, item.getUserId(), item.getAlbumId(), item.getTitle());
    }

}
