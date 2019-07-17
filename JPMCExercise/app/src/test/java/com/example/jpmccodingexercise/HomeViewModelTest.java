package com.example.jpmccodingexercise;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.example.jpmccodingexercise.data.Album;
import com.example.jpmccodingexercise.repo.AlbumsRepository;
import com.example.jpmccodingexercise.ui.home.HomeViewModel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class HomeViewModelTest {

    @BeforeClass
    public static void initialiseRxSchedulers() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(handler -> Schedulers.trampoline());
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private AlbumsRepository albumsRepository;

    @Mock
    private Observer<List<Album>> albumsObserver;

    private HomeViewModel homeViewModel;

    @Before
    public void setup() {
        homeViewModel = new HomeViewModel(albumsRepository);
    }

    @Test
    public void test_GetAlbums_WhenOnline_ReturnsAListOfAlbums() {
        //Given
        List<Album> albums = Collections
                .singletonList(new Album(0, 0, "Antigua Adventures"));
        Mockito.when(albumsRepository.getSortedAlbums(Mockito.anyBoolean()))
                .thenReturn(Observable.just(albums));

        //When
        homeViewModel.getAlbumsObservable().observeForever(albumsObserver);
        homeViewModel.getAlbums();

        //Then
        Mockito.verify(albumsObserver).onChanged(albums);

    }


}
