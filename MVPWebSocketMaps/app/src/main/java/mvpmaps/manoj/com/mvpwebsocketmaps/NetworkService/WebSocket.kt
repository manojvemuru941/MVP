package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService

import dagger.Module
import mvpmaps.manoj.com.mvpwebsocketmaps.BuildConfig
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI
import java.net.URISyntaxException

/**
 * Created by priyamanoj on 2018-02-06.
 */
@Module
class WebSocket constructor(uri: URI) {
    private var uri: URI? = null

    init {
        this.uri = uri
    }

        fun connectWS(webSocketContract: WebSocketContract){
            try {
                uri = URI(BuildConfig.WSURL)
            } catch (e: URISyntaxException) {
                e.printStackTrace()
                return
            }
            var mWebSocketClient = object : WebSocketClient(uri){

                override fun onOpen(handshakeData: ServerHandshake) {
                    webSocketContract.onOpen(handshakeData)
                }

                override fun onClose(code: Int, reason: String, remote: Boolean) {
                    webSocketContract.onClose(reason)
                }

                override fun onMessage(message: String) {
                    webSocketContract.onMessage(message)
                }

                override fun onError(ex: Exception) {
                    webSocketContract.onError(ex)
                }
            }

            mWebSocketClient.connect()
        }
}