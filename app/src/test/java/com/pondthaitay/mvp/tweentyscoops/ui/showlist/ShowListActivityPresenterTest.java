package com.pondthaitay.mvp.tweentyscoops.ui.showlist;

import android.util.Log;

import com.pondthaitay.mvp.tweentyscoops.api.BaseSubscriber;
import com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerApi;
import com.pondthaitay.mvp.tweentyscoops.api.beerlist.BeerServiceManager;
import com.pondthaitay.mvp.tweentyscoops.api.dao.BeerDao;
import com.pondthaitay.mvp.tweentyscoops.utils.JsonMockUtility;
import com.pondthaitay.mvp.tweentyscoops.utils.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.TestObserver;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class, CompositeDisposable.class})
public class ShowListActivityPresenterTest {
    @Rule
    public final RxSchedulersOverrideRule schedulers = new RxSchedulersOverrideRule();
    @Mock
    private ShowListActivityInterface.View mockView;
    @Mock
    private CompositeDisposable disposable;
    @Mock
    private BeerApi mockBeerApi;

    private ShowListActivityPresenter presenter;
    private JsonMockUtility jsonUtil;
    private ResponseBody responseBody;
    private BeerServiceManager beerServiceManager;

    @Before
    public void setup() {
        jsonUtil = new JsonMockUtility();

        MockitoAnnotations.initMocks(this);

        responseBody = ResponseBody.create(MediaType.parse("application/json"), "");

        beerServiceManager = BeerServiceManager.getInstance();
        beerServiceManager.setApi(mockBeerApi);
        beerServiceManager.setDisposable(disposable);

        presenter = new ShowListActivityPresenter();
        presenter.setBeerServiceManager(beerServiceManager);
        presenter.attachView(mockView);
        ShowListActivityPresenter spyPresenter = spy(presenter);
        spyPresenter.setBeerServiceManager(beerServiceManager);
        spyPresenter.attachView(mockView);
    }

    @After
    public void destroy() {
        presenter.detachView();
    }

    @Test
    public void testPresenterCreate() {
        assertNotNull(ShowListActivityPresenter.create());
    }

    @Test
    public void loadBeerListSuccess() throws Exception {
        BeerDao mockResult = jsonUtil.getJsonToMock(
                "beer_list_success.json",
                BeerDao.class);

        Response<BeerDao> mockResponse = Response.success(mockResult);
        Observable<Response<BeerDao>> mockObservable = Observable.just(mockResponse);
        when(beerServiceManager.requestBeerList(anyInt())).thenReturn(mockObservable);
        presenter.getListBeer();
        verify(mockView, times(1)).showProgressDialog();
        verify(disposable, times(1)).add(any(BaseSubscriber.class));

        TestObserver<Response<BeerDao>> testObserver = mockObservable.test();
        testObserver.awaitTerminalEvent();
        testObserver.assertValue(response -> {
            verify(mockView, times(1)).hideProgressDialog();
            verify(mockView, times(1)).setBeerItemToAdapter();
            assertThat(response, is(mockResponse));
            assertThat(response.body(), is(presenter.getBeerDao()));
            return true;
        });
    }

    @Test
    public void loadBeerListError() throws Exception {
        Response<BeerDao> mockResponse = Response.error(500, responseBody);
        mockResponse.message();
        Observable<Response<BeerDao>> mockObservable = Observable.just(mockResponse);
        when(beerServiceManager.requestBeerList(anyInt())).thenReturn(mockObservable);
        presenter.getListBeer();
        verify(mockView, times(1)).showProgressDialog();
        verify(disposable, times(1)).add(any(BaseSubscriber.class));

        TestObserver<Response<BeerDao>> testObserver = mockObservable.test();
        testObserver.awaitTerminalEvent();
        testObserver.assertValue(response -> {
            verify(mockView, times(1)).hideProgressDialog();
            verify(mockView, times(1)).showError(eq(response.message()));
            assertNull(presenter.getBeerDao());
            return true;
        });
    }

    @Test
    public void loadBeerListUnAuthorized() throws Exception {
        Response<BeerDao> mockResponse = Response.error(401, responseBody);
        Observable<Response<BeerDao>> mockObservable = Observable.just(mockResponse);
        when(beerServiceManager.requestBeerList(anyInt())).thenReturn(mockObservable);
        presenter.getListBeer();
        verify(mockView, times(1)).showProgressDialog();
        verify(disposable, times(1)).add(any(BaseSubscriber.class));

        TestObserver<Response<BeerDao>> testObserver = mockObservable.test();
        testObserver.awaitTerminalEvent();
        testObserver.assertValue(response -> {
            verify(mockView, times(1)).hideProgressDialog();
            verify(mockView, times(1)).unAuthorizedApi();
            assertNull(presenter.getBeerDao());
            return true;
        });
    }

    @Test
    public void testViewDestroy() throws Exception {
        presenter.onViewDestroy();
        assertNull(presenter.getBeerDao());
    }
}