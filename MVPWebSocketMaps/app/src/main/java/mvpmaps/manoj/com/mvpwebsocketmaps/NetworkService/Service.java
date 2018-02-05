package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService;

import mvpmaps.manoj.com.mvpwebsocketmaps.viewmodel.UserViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ennur on 6/25/16.
 */
public class Service {
    private final HTTPNetworkService networkService;

    public Service(HTTPNetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription userLogin(final GetCityListCallback callback) {

        return networkService.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends UserViewModel>>() {
                    @Override
                    public Observable<? extends UserViewModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<UserViewModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(UserViewModel response) {
                        callback.onSuccess(response);

                    }
                });
    }

    public interface GetCityListCallback{
        void onSuccess(UserViewModel response);

        void onError(NetworkError networkError);
    }
}
