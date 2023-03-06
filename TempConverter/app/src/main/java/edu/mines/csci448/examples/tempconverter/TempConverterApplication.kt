package edu.mines.csci448.examples.tempconverter

import android.app.Application
import android.util.Log

class TempConverterApplication : Application() {

    companion object {
        private const val LOG_TAG = "448.TCApp"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "onCreate() called")
    }
}