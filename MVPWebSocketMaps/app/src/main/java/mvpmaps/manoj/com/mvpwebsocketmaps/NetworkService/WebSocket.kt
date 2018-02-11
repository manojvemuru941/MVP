package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import mvpmaps.manoj.com.mvpwebsocketmaps.app.FamilyLocatorMVP
import mvpmaps.manoj.com.mvpwebsocketmaps.model.DataUpdateModel
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
//import org.java_websocket.client.WebSocketClient
//import org.java_websocket.handshake.ServerHandshake
import javax.inject.Singleton
import okhttp3.WebSocketListener
import okio.ByteString
import okhttp3.WebSocket;
import okhttp3.OkHttpClient
import okhttp3.Request


/**
 * Created by priyamanoj on 2018-02-06.
 */
@Module
@Singleton
class WebSocket constructor(url: String) {
    private var url: String? = null

    private var client: OkHttpClient? = null

    init {
        this.url = url
    }

    fun connectWS(){

        client = OkHttpClient()

        val request = Request.Builder().url(url).build()
        val listener = EchoWebSocketListener()
        val ws = client!!.newWebSocket(request, listener)
        client!!.dispatcher().executorService().shutdown()
    }

    private inner class EchoWebSocketListener : WebSocketListener() {

        override fun onOpen(webSocket: WebSocket?, response: okhttp3.Response?) {
            super.onOpen(webSocket, response)
            webSocket!!.send("GET DATA")
        }

        override fun onMessage(webSocket: WebSocket, message: String) {
            super.onMessage(webSocket, message)
            var gson:Gson = GsonBuilder().create()
            var update:DataUpdateModel.Update = gson.fromJson(message, DataUpdateModel.Update::class.java)

            when(update.updateType) {
                DataUpdateModel.FAMILY_UPDATE -> FamilyLocatorMVP.instance.familyModel.updateData(update.familyModel!!)
                DataUpdateModel.MEMBER_UPDATE -> {
                    FamilyLocatorMVP.instance.familyModel!!.members.forEach {
                        if(it.id == update.memberModel!!.id) {
                            it.updateMemberData(update.memberModel!!)
                        }
                    }
                }
            }
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            super.onMessage(webSocket, bytes)
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosing(webSocket, code, reason)
            //TODO: Do something when connection is closed
        }

        override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: okhttp3.Response?) {
            super.onFailure(webSocket, t, response)
            //TODO: Do something when connection is failed
        }
    }

    companion object {
        private val NORMAL_CLOSURE_STATUS = 1000
    }
}