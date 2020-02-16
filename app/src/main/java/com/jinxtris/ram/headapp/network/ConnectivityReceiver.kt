package com.jinxtris.ram.headapp.network

class ConnectivityReceiver : BroadcastReceiver() {


    private var passOnlyOnce: Boolean = false

    companion object {
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val isConnected = context?.isConnectedToInternet() == true
        if (passOnlyOnce != isConnected) {
            passOnlyOnce = isConnected
            connectivityReceiverListener?.onNetworkConnectionChanged(isConnected)
        }
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }
}