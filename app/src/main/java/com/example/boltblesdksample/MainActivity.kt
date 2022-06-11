package com.example.boltblesdksample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.boltCore.android.BoltSdk
import com.boltCore.android.managers.BoltManager
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var boltManager: BoltManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bookingObj = "" //insert booking object here

        setupViews()

        boltManager = BoltSdk.getBoltManager(this, applicationContext, bookingObj)

        boltManager.setCallBack(boltManagerCallback)

    }

    private val boltManagerCallback = object : BoltManager.Callback {
        override fun onError(status: String) {
            Timber.d("onError: %s", status)
            Toast.makeText(applicationContext, "onError: " + status, Toast.LENGTH_SHORT).show()
        }

        override fun onChargerFound(chargerId: String, status: String) {
            super.onChargerFound(chargerId, status)
            Timber.d("onChargerFound: chargerId: %s   |   status: %s", chargerId, status)
            Toast.makeText(applicationContext, "onChargerFound" + chargerId, Toast.LENGTH_SHORT).show()
        }

        override fun onChargerConnected(chargerId: String, bleName: String, status: String) {
            super.onChargerConnected(chargerId, bleName, status)
            Timber.d("onChargerConnected: chargerId: %s | bleName: %s | status: %s", chargerId, bleName, status)
            Toast.makeText(applicationContext, "onChargerConnected" + chargerId, Toast.LENGTH_SHORT).show()

        }

        override fun onChargerConnectionFailed(status: String) {
            super.onChargerConnectionFailed(status)
            Timber.d("onChargerConnectionFailed: %s", status)
            Toast.makeText(applicationContext, "onChargerConnectionFailed: " + status, Toast.LENGTH_SHORT).show()

        }

        override fun onChargingStarted() {
            super.onChargingStarted()
            Timber.d("onChargingStarted")
            Toast.makeText(applicationContext, "onChargingStarted", Toast.LENGTH_SHORT).show()

        }

        override fun onChargingStopped() {
            super.onChargingStopped()
            Timber.d("onChargingStopped")
            Toast.makeText(applicationContext, "onChargingStopped", Toast.LENGTH_SHORT).show()

        }

        override fun onDisconnected(chargerId: String, bleName: String, status: String) {
            super.onDisconnected(chargerId, bleName, status)
            Timber.d("onDisconnected: chargerId: %s | bleName: %s | status: %s", chargerId, bleName, status)
            Toast.makeText(applicationContext, "onDisconnected" + chargerId, Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupViews() {
        val startChargingButton = findViewById<View>(R.id.start_charging) as Button
        val stopChargingButton = findViewById<View>(R.id.stop_charging) as Button
        val endChargingButton = findViewById<View>(R.id.end_charging) as Button
        val connectToDeviceButton = findViewById<View>(R.id.connect_to_device) as Button

        startChargingButton.setOnClickListener {
            boltManager.startCharger()
        }

        stopChargingButton.setOnClickListener {
            boltManager.stopCharger()
        }

        endChargingButton.setOnClickListener {
            boltManager.endBooking()
        }

        connectToDeviceButton.setOnClickListener {
            boltManager.connectToDevice()
        }
    }
}