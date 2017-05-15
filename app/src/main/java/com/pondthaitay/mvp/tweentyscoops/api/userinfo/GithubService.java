package com.pondthaitay.mvp.tweentyscoops.api.userinfo;

import com.pondthaitay.mvp.tweentyscoops.api.BaseService;

class GithubService extends BaseService<GithubApi> {

    static GithubService newInstance(String baseUrl) {
        GithubService service = new GithubService();
        service.setBaseUrl(baseUrl);
        return service;
    }

    @Override
    protected Class<GithubApi> getApiClassType() {
        return GithubApi.class;
    }
}
