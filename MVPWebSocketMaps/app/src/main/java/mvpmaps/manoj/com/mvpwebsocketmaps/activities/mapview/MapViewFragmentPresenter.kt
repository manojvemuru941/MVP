package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.google.android.gms.maps.GoogleMap
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import javax.inject.Inject
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import mvpmaps.manoj.com.mvpwebsocketmaps.app.FamilyLocatorMVP
import mvpmaps.manoj.com.mvpwebsocketmaps.loadBitmap
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
* Created by Manoj Vemuru on 2018-02-06.
*/
class MapViewFragmentPresenter
@Inject constructor(webSocket: WebSocket, mapViewFragment: MapViewContract.View,
                    context: Application) : MapViewContract.Presenter {

    private var webSocketService: WebSocket? = null
    private var view: MapViewContract.View? = null
    private var context:Context
    private var memberModel:MemberModel? = null
    private var familyModel:FamilyModel? = null
    private var memberLocationUpdateSubscription:Subscription? = null

    init {
        this.webSocketService = webSocket
        this.view = mapViewFragment
        this.context = context
        this.familyModel = FamilyLocatorMVP.instance.familyModel
    }

    override fun onMapReady(googleMap: GoogleMap) {
        if ( ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION )
                == PackageManager.PERMISSION_GRANTED ) {
            googleMap.isMyLocationEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isCompassEnabled = true

            setMapLocation(this.memberModel!!, googleMap)
            memberLocationUpdateSubscription = this.memberModel!!.observeUpdateMemberModel()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        value -> setMapLocation(value, googleMap)
            }
        }
    }

    private fun setMapLocation(memberModel: MemberModel, googleMap: GoogleMap) {
        val position = LatLng(memberModel.lat!!, memberModel.long!!)


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,15.0f));

        var options = MarkerOptions()
        options.title(memberModel?.name)
        options.icon(BitmapDescriptorFactory.fromBitmap(loadBitmap(context, memberModel?.image!!)))
        googleMap.addMarker(MarkerOptions().position(position))

        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f), 2000, null);
    }

    override fun setMemberModelId(memberModelId: String) {
        this.familyModel = familyModel
        this.familyModel?.members?.forEach {
            if (it.id.equals(memberModelId)) {
                this.memberModel = it
            }
        }
    }

    override fun onStart() {

    }

    override fun onCreate(view: View, bundle: Bundle?) {
        var memberModelId = bundle?.getString(MapViewFragment.TAG) as String
        setMemberModelId(memberModelId)
    }

    override fun onResume() {

    }

    override fun onPause() {
        memberLocationUpdateSubscription?.unsubscribe()
    }

    override fun onStop() {

    }

    override fun onDestroy() {
        memberLocationUpdateSubscription?.unsubscribe()
    }

}