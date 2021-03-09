package com.du.technicaltest.ui.viewmodel;
import com.du.technicaltest.model.MoviesResponse;
import com.du.technicaltest.network.ApiService;
import com.du.technicaltest.network.RetroInstance;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    @Inject
    public MovieListViewModel(MutableLiveData<MoviesResponse> movieList) {
        this.movieList = movieList;
    }

    MutableLiveData<MoviesResponse> movieList;

    public MovieListViewModel() {
        movieList = new MutableLiveData<>();
    }

    public MutableLiveData<MoviesResponse> getMovieListObserver() {
        return movieList;
    }

    public void apiServiceCall(){
        ApiService apiService = RetroInstance.getRetroClient().create(ApiService.class);
        Call<MoviesResponse> call = apiService.getMovieList("bb60de15dafbc3b7405fb9a23b7ea47e");
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                movieList.postValue(response.body());
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
