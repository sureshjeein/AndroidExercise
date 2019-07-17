package com.example.jpmccodingexercise.di;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.data.AlbumDto;
import com.example.jpmccodingexercise.data.AlbumEntity;
import com.example.jpmccodingexercise.mapper.Mapper;
import com.example.jpmccodingexercise.repo.AlbumsRepository;
import com.example.jpmccodingexercise.repo.AlbumsRepositoryImpl;
import com.example.jpmccodingexercise.repo.LocalDataSource;
import com.example.jpmccodingexercise.repo.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class RepositoryModule {
    @Provides
    @Singleton
    AlbumsRepository provideAlbumsRepository(LocalDataSource localDataSource,
                                             RemoteDataSource remoteDataSource,
                                             Mapper<AlbumDto, Album> albumDtoToAlbumMapper,
                                             Mapper<AlbumEntity, Album> albumEntityToAlbumMapper,
                                             Mapper<AlbumDto, AlbumEntity> albumDtoToAlbumEntityMapper) {
        return new AlbumsRepositoryImpl(localDataSource, remoteDataSource, albumDtoToAlbumMapper,
                albumEntityToAlbumMapper, albumDtoToAlbumEntityMapper);
    }
}
