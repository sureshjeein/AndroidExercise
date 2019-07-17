package com.example.jpmccodingexercise.repo;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.data.AlbumDto;
import com.example.jpmccodingexercise.data.AlbumEntity;
import com.example.jpmccodingexercise.mapper.Mapper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class AlbumsRepositoryImpl implements AlbumsRepository {

    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;
    private final Mapper<AlbumDto, Album> albumDtoToAlbumMapper;
    private final Mapper<AlbumEntity, Album> albumEntityToAlbumMapper;
    private final Mapper<AlbumDto, AlbumEntity> albumDtoToAlbumEntityMapper;


    public AlbumsRepositoryImpl(LocalDataSource localDataSource, RemoteDataSource remoteDataSource,
                                Mapper<AlbumDto, Album> albumDtoToAlbumMapper,
                                Mapper<AlbumEntity, Album> albumEntityToAlbumMapper,
                                Mapper<AlbumDto, AlbumEntity> albumDtoToAlbumEntityMapper) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.albumDtoToAlbumMapper = albumDtoToAlbumMapper;
        this.albumEntityToAlbumMapper = albumEntityToAlbumMapper;
        this.albumDtoToAlbumEntityMapper = albumDtoToAlbumEntityMapper;
    }


    @Override
    public Observable<List<Album>> getSortedAlbums(boolean isAscending) {
        return remoteDataSource.getAlbums()
                .doOnSuccess(this::addAlbumsToDb)
                .toObservable()
                .map(albumDtoToAlbumMapper::mapList)
                .onErrorResumeNext(retrieveDataFromDb())
                .observeOn(Schedulers.computation())
                .flatMap(Observable::fromIterable)
                .toSortedList((albumOne, albumTwo) -> albumOne.getTitle().compareTo(albumTwo.getTitle()))
                .toObservable();
    }

    private void addAlbumsToDb(List<AlbumDto> albumDtoList) {
        localDataSource.deleteAllAlbums();
        localDataSource.addAlbums(albumDtoToAlbumEntityMapper
                .mapList(albumDtoList).toArray(new AlbumEntity[albumDtoList.size()]));
    }

    private Observable<List<Album>> retrieveDataFromDb() {
        return localDataSource.getAlbums()
                .map(albumEntityToAlbumMapper::mapList)
                .toObservable();
    }
}
