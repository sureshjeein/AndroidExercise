package com.example.jpmccodingexercise.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jpmccodingexercise.repo.AlbumsRepository;

import javax.inject.Inject;

public class HomeViewModelFactory implements ViewModelProvider.Factory {


    private final AlbumsRepository albumsRepository;

    @Inject
    HomeViewModelFactory(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(albumsRepository);
        }
        throw new IllegalArgumentException("Please make sure the parameter is of type " +
                HomeViewModel.class.getSimpleName());
    }
}
