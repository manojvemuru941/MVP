package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService

import java.lang.Exception

/**
 * Created by priyamanoj on 2018-02-06.
 */
interface WebSocketContract {
//    fun onOpen(handshakeData: ServerHandshake)
    fun onClose(reason: String)
    fun onMessage(message: String)
    fun onError(ex: Exception)
}