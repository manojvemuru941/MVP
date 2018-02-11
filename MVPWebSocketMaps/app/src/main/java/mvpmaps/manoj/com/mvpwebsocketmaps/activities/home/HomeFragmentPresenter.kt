package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.NetworkError
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.Service
import mvpmaps.manoj.com.mvpwebsocketmaps.model.UserModel
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-05.
 */
class HomeFragmentPresenter @Inject constructor(service: Service, homeView: HomeFragmentContract.View) : HomeFragmentContract.HomePresenter {
    private var service: Service? = null
    private var view: HomeFragmentContract.View? = null
    private var subscriptions: CompositeSubscription? = null

    init {
        this.service = service;
        this.view = homeView;
        this.subscriptions = CompositeSubscription()
    }

    override fun login() {

        val subscription  = service?.userLogin(object :Service.GetCityListCallback {
            override fun onSuccess(response: UserModel) {
                view?.removeWait()
                view?.success(response)
            }
                override fun onError(networkError: NetworkError) {
                view?.removeWait()
                view?.onFailure(networkError.appErrorMessage)
            }
        })

        subscriptions?.add(subscription)
    }

    override fun logout() {

        val subscription  = service?.userLogout(object :Service.GetCityListCallback {
            override fun onSuccess(cityListResponse: UserModel) {
                view?.removeWait()
                view?.success(cityListResponse)
            }
            override fun onError(networkError: NetworkError) {
                view?.removeWait()
                view?.onFailure(networkError.appErrorMessage)
            }
        })

        subscriptions?.add(subscription)
    }

    fun onStop() {
        subscriptions?.unsubscribe()
    }
}