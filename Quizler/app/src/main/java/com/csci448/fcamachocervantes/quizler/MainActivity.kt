package com.csci448.fcamachocervantes.quizler

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.csci448.fcamachocervantes.quizler.presentation.navigation.QuizlerNavHost
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModel
import com.csci448.fcamachocervantes.quizler.presentation.viewmodel.QuizlerViewModelFactory
import com.csci448.fcamachocervantes.quizler.ui.theme.QuizlerTheme

class MainActivity : ComponentActivity() {
    companion object {
        private const val LOG_TAG = "448.MainActivity"
        private const val KEY_INDEX = "index"
        private const val KEY_SCORE = "score"
    }

    private lateinit var mViewModel: QuizlerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate() called")

        val initialIndex = savedInstanceState?.getInt(KEY_INDEX, 0)?: 0
        val initialScore = savedInstanceState?.getInt(KEY_SCORE, 0)?: 0

        Log.d(LOG_TAG, "Initial Index: " + initialIndex)
        Log.d(LOG_TAG, "Initial Score: " + initialScore)

        val factory = QuizlerViewModelFactory(initialIndex = initialIndex, initialScore = initialScore)
        mViewModel = ViewModelProvider(this, factory)[factory.getViewModelClass()]

        setContent {
            QuizlerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    QuizlerNavHost(navController = navController, quizlerViewModel = mViewModel)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        Log.d(LOG_TAG, "onSaveInstanceState called")
        outState.putInt(KEY_INDEX, mViewModel.currentQuestionIndex)
        outState.putInt(KEY_SCORE, mViewModel.currentScoreState.value)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy() called")
    }

    override fun onContentChanged() {
        super.onContentChanged()
        Log.d(LOG_TAG, "onContentChanged() called")
    }

    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        Log.d(LOG_TAG, "onPostCreate() called")
    }

    override fun onPostResume(){
        super.onPostResume()
        Log.d(LOG_TAG, "onPostResume() called")
    }

    override fun onAttachedToWindow(){
        super.onAttachedToWindow()
        Log.d(LOG_TAG, "onAttachedToWindow() called")
    }

    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
        Log.d(LOG_TAG, "onEnterAnimationComplete() called")
    }

    override fun onDetachedFromWindow(){
        super.onDetachedFromWindow()
        Log.d(LOG_TAG, "onDetachedFromWindow() called")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}