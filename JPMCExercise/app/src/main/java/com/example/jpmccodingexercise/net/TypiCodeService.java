package com.example.jpmccodingexercise.net;

import com.example.jpmccodingexercise.BuildConfig;
import com.example.jpmccodingexercise.data.AlbumDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface TypiCodeService {

    @GET(BuildConfig.ALBUMS_ENDPOINT)
    Single<List<AlbumDto>> getAlbums();

}
