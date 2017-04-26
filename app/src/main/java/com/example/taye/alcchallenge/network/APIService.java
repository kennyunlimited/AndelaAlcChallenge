package com.example.taye.alcchallenge.network;

import com.example.taye.alcchallenge.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TAYE on 21/04/2017.
 */

public interface APIService {
    @GET("search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}

