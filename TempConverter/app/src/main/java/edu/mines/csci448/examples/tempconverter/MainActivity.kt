package edu.mines.csci448.examples.tempconverter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.mines.csci448.examples.tempconverter.presentation.ConvertScreen
import edu.mines.csci448.examples.tempconverter.presentation.TemperatureViewModel
import edu.mines.csci448.examples.tempconverter.ui.theme.TempConverterTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val LOG_TAG = "448.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate() called")
        setContent {
            TempConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ConvertScreen(TemperatureViewModel())
                }
            }
        }
    }


    override  fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart() called")
    }

    override  fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop() called")
    }

    override  fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause() called")
    }

    override  fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume() called")
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    TempConverterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ConvertScreen(TemperatureViewModel())
        }
    }
}