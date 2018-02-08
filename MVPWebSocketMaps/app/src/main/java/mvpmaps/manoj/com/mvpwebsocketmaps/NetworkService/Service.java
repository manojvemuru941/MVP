package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService;

import dagger.Module;
import mvpmaps.manoj.com.mvpwebsocketmaps.model.UserModel;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ennur on 6/25/16.
 */
@Module
public class Service {
    private final HTTPNetworkService networkService;

    public Service(HTTPNetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription userLogin(final GetCityListCallback callback) {

        return networkService.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends UserModel>>() {
                    @Override
                    public Observable<? extends UserModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<UserModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(UserModel response) {
                        callback.onSuccess(response);

                    }
                });
    }

    public Subscription userLogout(final GetCityListCallback callback) {

        return networkService.logout()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends UserModel>>() {
                    @Override
                    public Observable<? extends UserModel> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<UserModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(UserModel response) {
                        callback.onSuccess(response);

                    }
                });
    }

    public interface GetCityListCallback{
        void onSuccess(UserModel response);

        void onError(NetworkError networkError);
    }
}
