package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import rx.subjects.PublishSubject


/**
 * Created by priyamanoj on 2018-02-06.
 */
class MapViewFragmentPresenter @Inject constructor(webSocket: WebSocket, mapViewFragment: MapViewContract.View, context: Application) : MapViewContract.Presenter {

    private var webSocketService: WebSocket? = null
    private var view: MapViewContract.View? = null
    private var subscriptions: CompositeSubscription? = null
    private var context:Context
    private var mapSubject: Subject<GoogleMap>? = null

    init {
        this.webSocketService = webSocket;
        this.view = mapViewFragment;
        this.subscriptions = CompositeSubscription()
        this.context = context
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mapSubject =  BehaviorSubject.create();
        if ( ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED ) {
            googleMap.isMyLocationEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isCompassEnabled = true

            val position = LatLng(49.215761, -123.097818)

            val position2 = LatLng(51.215761, -123.097818)

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,15.0f));

            googleMap.addMarker(MarkerOptions()
                    .position(position))
            googleMap.addMarker(MarkerOptions()
                    .position(position2))

            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f), 2000, null);

        }
    }

    fun addMarker(location: Location) {
        mapSubject?.subscribe({ googleMap ->
            val position = LatLng(0.0, 0.0)
            googleMap.addMarker(MarkerOptions()
                    .position(position))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        })
    }

}