package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerApi;
import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;
import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class ShowListActivityPresenter extends BasePresenter<ShowListInterface.View>
        implements ShowListInterface.Presenter, BaseSubscriber.NetworkCallback {

    private BeerApi beerApi;
    private BeerDao beerDao;

    public static ShowListInterface.Presenter create() {
        return new ShowListActivityPresenter();
    }

    ShowListActivityPresenter() {
        super();
//        this.beerApi = beerApi;
    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewStop() {

    }

    @Override
    public void getListBeer() {
        if (getView() != null) {
            getView().showProgressDialog();
            beerApi.getListBeer(getNextPage())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<>(this));
        }
    }

    private int getNextPage() {
        if (beerDao == null) return 0;
        else return beerDao.getNextBeerIndex();
    }

    @Override
    public <T> void onSuccess(T result) {
        if (getView() != null) {
            beerDao = (BeerDao) result;
            getView().hideProgressDialog();
            getView().setBeerItemToAdapter();
        }
    }

    @Override
    public void onFailure(String message) {
        if (getView() != null) {
            beerDao = null;
            getView().hideProgressDialog();
            getView().showError(message);
        }
    }
}
