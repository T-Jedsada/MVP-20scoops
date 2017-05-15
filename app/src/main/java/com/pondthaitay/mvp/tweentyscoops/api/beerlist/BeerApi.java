package com.pondthaitay.mvp.tweentyscoops.api.beerlist;

import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApi {

    @GET("api/v1/beer")
    Observable<Response<BeerDao>> getListBeer(@Query("page") int page);
}
