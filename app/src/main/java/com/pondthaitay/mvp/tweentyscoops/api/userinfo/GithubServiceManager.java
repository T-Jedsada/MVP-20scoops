package com.pondthaitay.mvp.tweentyscoops.api.userinfo;

import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.dao.UserInfoDao;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static com.pondthaitay.mvp.tweentyscoops.api.userinfo.GithubURL.BASE_URL;

public class GithubServiceManager {

    private static GithubServiceManager instance;
    private static GithubApi api;

    private CompositeDisposable disposable;

    public static GithubServiceManager getInstance() {
        if (instance == null) {
            instance = new GithubServiceManager();
        }
        return instance;
    }

    private GithubServiceManager() {
        this.disposable = new CompositeDisposable();
    }

    public static void setApi(GithubApi mockApi) {
        api = mockApi;
    }

    public void requestUserInfo(String username, final BaseSubscriber.NetworkCallback callback) {
        disposable.add(requestUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseSubscriber<>(callback)));
    }

    public Observable<Response<UserInfoDao>> requestUserInfo(String username) {
        return GithubService.newInstance(BASE_URL)
                .getApi(api)
                .getUserInfo(username);
    }

    public void clearDisposable() {
        if (disposable != null) disposable.clear();
    }
}
