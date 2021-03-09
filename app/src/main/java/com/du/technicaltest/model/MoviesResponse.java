package com.du.technicaltest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class MoviesResponse {

    public MoviesResponse() {
        this.results = new ArrayList<>();
    }

    @SerializedName("results")
    private List<MovieModel> results;

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

}
