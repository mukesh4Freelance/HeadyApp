package com.jinxtris.ram.headapp

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.jinxtris.ram.headapp.network.ConnectivityReceiver
import com.jinxtris.ram.headapp.utils.TAG
import java.io.PrintWriter
import java.io.StringWriter

class AppContext : Application() {
    companion object {
        private var instance: AppContext? = null

        @Synchronized
        fun getInstance(): AppContext {
            return instance!!
        }
    }

    init {
        instance = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        //ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleListener)/
        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            handleUncaughtException(e)
        }
    }

    private fun handleUncaughtException(e: Throwable) {
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        e.printStackTrace(pw)
        Log.e(TAG, sw.toString())
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = listener
    }

}