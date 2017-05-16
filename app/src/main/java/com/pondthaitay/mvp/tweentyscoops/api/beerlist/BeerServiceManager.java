package com.pondthaitay.mvp.tweentyscoops.api.beerlist;

import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerURL.BASE_URL;

public class BeerServiceManager {

    private static BeerServiceManager instance;
    private BeerApi api;

    private CompositeDisposable disposable;

    public static BeerServiceManager getInstance() {
        if (instance == null) {
            instance = new BeerServiceManager();
        }
        return instance;
    }

    private BeerServiceManager() {
        this.disposable = new CompositeDisposable();
    }

    public void setApi(BeerApi mockApi) {
        api = mockApi;
    }

    public void setDisposable(CompositeDisposable disposable) {
        this.disposable = disposable;
    }

    public void requestBeerList(int nextPage, final BaseSubscriber.NetworkCallback callback) {
        disposable.add(requestBeerList(nextPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseSubscriber<>(callback)));
    }

    public Observable<Response<BeerDao>> requestBeerList(int nextPage) {
        return BeerService.newInstance(BASE_URL)
                .getApi(api)
                .getListBeer(nextPage);
    }

    public void clearDisposable() {
        if (disposable != null) disposable.clear();
    }
}
