package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-06.
 */
class MapViewFragmentPresenter @Inject constructor(webSocket: WebSocket, mapViewFragment: MapViewContract.View) : MapViewContract.Presenter {
    private var webSocketService: WebSocket? = null
    private var view: MapViewContract.View? = null
    private var subscriptions: CompositeSubscription? = null

    init {
        this.webSocketService = webSocket;
        this.view = mapViewFragment;
        this.subscriptions = CompositeSubscription()
    }


}