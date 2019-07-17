package com.example.jpmccodingexercise.ui.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.idling.CountingIdlingResource;

import com.example.jpmccodingexercise.R;
import com.example.jpmccodingexercise.databinding.ActivityHomeBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class HomeActivity extends AppCompatActivity {

    @Inject
    HomeViewModel homeViewModel;

    private final CountingIdlingResource countingIdlingResource =
            new CountingIdlingResource(HomeActivity.class.getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityHomeBinding activityHomeBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_home);
        activityHomeBinding.setLifecycleOwner(this);
        activityHomeBinding.setHomeViewModel(homeViewModel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        AlbumsAdapter albumsAdapter = new AlbumsAdapter();
        RecyclerView recyclerView = findViewById(R.id.rv_albums);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                linearLayoutManager.getOrientation()));
        recyclerView.setAdapter(albumsAdapter);

        homeViewModel.getAlbumsObservable().observe(this, result -> {
            albumsAdapter.setData(result);
            countingIdlingResource.decrement();
        });
        homeViewModel.getErrorObservable().observe(this, this::handleError);
        countingIdlingResource.increment();
        homeViewModel.getAlbums();

    }

    private void handleError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        countingIdlingResource.decrement();
    }

    public CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }
}
