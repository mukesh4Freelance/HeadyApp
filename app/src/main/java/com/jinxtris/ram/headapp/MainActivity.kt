package com.jinxtris.ram.headapp

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jinxtris.ram.headapp.network.ConnectivityReceiver
import com.jinxtris.ram.headapp.utils.TAG
import com.jinxtris.ram.headapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var mainViewModel: MainViewModel
    private lateinit var navController: NavController
    private lateinit var connectivityReceiver: ConnectivityReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeResources()
    }

    private fun initializeResources() {
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        navController = findNavController(R.id.navHostFragment)
        supportActionBar?.hide()
    }

    override fun onResume() {
        super.onResume()
        registerBroadcast()
    }

    override fun onPause() {
        super.onPause()
        unRegisterBroadcast()
    }

    private fun registerBroadcast() {
        Log.e(TAG, "Register Broadcast")
        val filters = IntentFilter()
        filters.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        filters.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filters.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        connectivityReceiver = ConnectivityReceiver()
        registerReceiver(connectivityReceiver, filters)
    }

    private fun unRegisterBroadcast() {
        Log.e(TAG, "Unregister Broadcast")
        unregisterReceiver(connectivityReceiver)
    }

    override fun onBackPressed() {
        when (navController.currentDestination?.id) {
            R.id.homeFragment -> {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed()
                    finish()
                    return
                }

                this.doubleBackToExitPressedOnce = true

                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Tap again to exit",
                    Snackbar.LENGTH_SHORT
                ).show()

                Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
            }
            else -> {
                super.onBackPressed()
                return
            }
        }
    }
}
