package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerServiceManager;
import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;
import com.pondthaitay.mvp.tweentyscoops.ui.base.BasePresenter;

class ShowListActivityPresenter extends BasePresenter<ShowListActivityInterface.View>
        implements ShowListActivityInterface.Presenter, BaseSubscriber.NetworkCallback {

    private BeerServiceManager beerServiceManager;
    private BeerDao beerDao;

    public static ShowListActivityInterface.Presenter create() {
        return new ShowListActivityPresenter();
    }

    ShowListActivityPresenter() {
        beerServiceManager = BeerServiceManager.getInstance();
    }

    void setBeerServiceManager(BeerServiceManager mock) {
        this.beerServiceManager = mock;
    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewDestroy() {
        setBeerDao(null);
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
            beerServiceManager.requestBeerList(getNextPage(), this);
        }
    }

    @Override
    public <T> void onSuccess(T result) {
        if (getView() != null) {
            setBeerDao((BeerDao) result);
            getView().hideProgressDialog();
            getView().setBeerItemToAdapter();
        }
    }

    @Override
    public void onFailure(String message) {
        if (getView() != null) {
            setBeerDao(null);
            getView().hideProgressDialog();
            getView().showError(message);
        }
    }

    @Override
    public void onUnAuthorized() {
        super.onUnAuthorized();
        setBeerDao(null);
    }

    BeerDao getBeerDao() {
        return beerDao;
    }

    private void setBeerDao(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    private int getNextPage() {
        if (beerDao == null) return 0;
        else return beerDao.getNextBeerIndex();
    }
}
