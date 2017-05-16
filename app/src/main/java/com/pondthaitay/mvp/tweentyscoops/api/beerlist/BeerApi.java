package com.pondthaitay.mvp.tweentyscoops.api.beerlist;

import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerURL.BEER_LIST;

public interface BeerApi {

    @GET(BEER_LIST)
    Observable<Response<BeerDao>> getListBeer(@Query("page") int page);
}
