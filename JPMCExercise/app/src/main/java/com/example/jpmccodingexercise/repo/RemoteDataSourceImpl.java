package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.AlbumDto;
import com.example.jpmccodingexercise.net.TypiCodeService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSourceImpl implements RemoteDataSource {

    private final TypiCodeService typiCodeService;

    @Inject
    public RemoteDataSourceImpl(TypiCodeService typiCodeService) {
        this.typiCodeService = typiCodeService;
    }

    @Override
    public Single<List<AlbumDto>> getAlbums() {
        return typiCodeService.getAlbums();
    }
}
