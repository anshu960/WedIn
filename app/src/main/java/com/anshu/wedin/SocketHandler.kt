package com.anshu.wedin

import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {
    lateinit var mSocket: Socket
    @Synchronized fun setSocket(){
        try{
            mSocket=IO.socket("http://10.0.2.2:64916")
        } catch (e:URISyntaxException){

        }
    }
    @Synchronized fun closeConnection(){
        mSocket.disconnect()
    }
}