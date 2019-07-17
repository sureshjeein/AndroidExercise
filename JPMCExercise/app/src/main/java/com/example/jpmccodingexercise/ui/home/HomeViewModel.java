package com.example.jpmccodingexercise.ui.home;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.repo.AlbumsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.annotation.VisibleForTesting.PROTECTED;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<Album>> albumsObservable;
    private final MutableLiveData<Boolean> progressObservable;
    private final MutableLiveData<String> errorObservable;

    private final AlbumsRepository albumsRepository;

    private final CompositeDisposable compositeDisposable;


    public HomeViewModel(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
        albumsObservable = new MutableLiveData<>();
        progressObservable = new MutableLiveData<>();
        errorObservable = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();
    }

    @VisibleForTesting(otherwise = PROTECTED)
    public void getAlbums() {
        if (albumsObservable.getValue() == null) {
            compositeDisposable.add(albumsRepository.getSortedAlbums(true)
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe(consumer -> progressObservable.setValue(true))
                    .doOnEach(notification -> progressObservable.postValue(false))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(albumsObservable::setValue,
                            throwable -> errorObservable.setValue(throwable.getMessage())));
        }
    }

    public LiveData<List<Album>> getAlbumsObservable() {
        return albumsObservable;
    }

    public LiveData<Boolean> getProgressObservable() {
        return progressObservable;
    }

    LiveData<String> getErrorObservable() {
        return errorObservable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
