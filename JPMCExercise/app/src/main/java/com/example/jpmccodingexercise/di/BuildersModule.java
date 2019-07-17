package com.example.jpmccodingexercise.di;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.data.AlbumDto;
import com.example.jpmccodingexercise.data.AlbumEntity;
import com.example.jpmccodingexercise.mapper.AlbumDtoToAlbumEntityMapper;
import com.example.jpmccodingexercise.mapper.AlbumDtoToAlbumMapper;
import com.example.jpmccodingexercise.mapper.AlbumEntityToAlbumMapper;
import com.example.jpmccodingexercise.mapper.Mapper;
import com.example.jpmccodingexercise.repo.LocalDataSource;
import com.example.jpmccodingexercise.repo.LocalDataSourceImpl;
import com.example.jpmccodingexercise.repo.RemoteDataSource;
import com.example.jpmccodingexercise.repo.RemoteDataSourceImpl;
import com.example.jpmccodingexercise.ui.home.HomeActivity;
import com.example.jpmccodingexercise.ui.home.di.HomeModule;
import com.example.jpmccodingexercise.ui.home.di.HomeScope;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class BuildersModule {


    @ContributesAndroidInjector(modules = HomeModule.class)
    @HomeScope
    abstract HomeActivity homeActivity();

    @Binds
    abstract RemoteDataSource bindRemoteDataSource(RemoteDataSourceImpl remoteDataSource);

    @Binds
    abstract LocalDataSource bindLocalDataSource(LocalDataSourceImpl localDataSource);

    @Binds
    abstract Mapper<AlbumDto, Album> bindAlbumDtoToAlbumMapper(
            AlbumDtoToAlbumMapper albumDtoToAlbumMapper);

    @Binds
    abstract Mapper<AlbumEntity, Album> bindAlbumEntityToAlbumMapper(
            AlbumEntityToAlbumMapper albumEntityToAlbumMapper);

    @Binds
    abstract Mapper<AlbumDto, AlbumEntity> bindAlbumDtoToAlbumEntityMapper(
            AlbumDtoToAlbumEntityMapper albumDtoToAlbumEntityMapper);
}
