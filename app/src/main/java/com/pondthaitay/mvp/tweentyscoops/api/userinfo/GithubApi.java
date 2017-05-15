package com.pondthaitay.mvp.tweentyscoops.api.userinfo;

import com.pondthaitay.mvp.tweentyscoops.api.dao.UserInfoDao;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.pondthaitay.mvp.tweentyscoops.api.userinfo.GithubURL.URL_INFO;

public interface GithubApi {

    @GET(URL_INFO)
    Observable<Response<UserInfoDao>> getUserInfo(@Path("userName") String userName);
}