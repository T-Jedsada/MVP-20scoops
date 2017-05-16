package com.pondthaitay.mvp.tweentyscoops.api.beerlist;

import com.pondthaitay.mvp.tweentyscoops.api.BaseService;

class BeerService extends BaseService<BeerApi> {

    static BeerService newInstance(String baseUrl) {
        BeerService service = new BeerService();
        service.setBaseUrl(baseUrl);
        return service;
    }

    @Override
    protected Class<BeerApi> getApiClassType() {
        return BeerApi.class;
    }
}