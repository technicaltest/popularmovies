package com.du.technicaltest.data.repository;


import com.du.technicaltest.data.NetworkBoundResource;
import com.du.technicaltest.data.Resource;
import com.du.technicaltest.data.Resource;
import com.du.technicaltest.model.MovieModel;
import com.du.technicaltest.model.MoviesResponse;
import com.du.technicaltest.network.ApiService;

import java.util.List;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.Observable;


/*
 * One of the first things we do in the Repository class
 * is to make it a Singleton.
 * */

@Singleton
public class MovieRepository {

    private ApiService movieApiService;

    public MovieRepository(ApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    /*
     * We are using this method to fetch the movies list
     * NetworkBoundResource is part of the Android architecture
     * components. You will notice that this is a modified version of
     * that class. That class is based on LiveData but here we are
     * using Observable from RxJava.
     *
     * There are three methods called:
     * a. fetch data from server
     * b. fetch data from local
     * c. save data from api in local
     *
     * So basically we fetch data from server, store it locally
     * and then fetch data from local and update the UI with
     * this data.
     *
     * */
    public Observable<Resource<List<MoviesResponse>>> loadMoviesByType() {
        return new NetworkBoundResource<List<MoviesResponse>, MoviesResponse>() {

            @Override
            protected void saveCallResult(@NonNull MoviesResponse item) {

            }

            @Override
            protected boolean shouldFetch() {
                return false;
            }

            @NonNull
            @Override
            protected Flowable<List<MoviesResponse>> loadFromDb() {
                return null;
            }

            @NonNull
            @Override
            protected Observable<Resource<MoviesResponse>> createCall() {
                return null;
            }
        }.getAsObservable();
    }
}
