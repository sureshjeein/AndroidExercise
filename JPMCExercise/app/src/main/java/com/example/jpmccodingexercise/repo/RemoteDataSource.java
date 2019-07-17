package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.AlbumDto;

import java.util.List;

import io.reactivex.Single;

public interface RemoteDataSource {
    Single<List<AlbumDto>> getAlbums();
}
