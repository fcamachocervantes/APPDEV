package com.csci448.fcamachocervantes.monsterlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.csci448.fcamachocervantes.monsterlab.data.Monster
import com.csci448.fcamachocervantes.monsterlab.ui.theme.MonsterLabTheme
import com.csci448.fcamachocervantes.monsterlab.presentation.MonsterDisplay
import com.csci448.fcamachocervantes.monsterlab.presentation.MonsterList
import com.csci448.fcamachocervantes.monsterlab.presentation.MonsterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonsterLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val monsterViewModel = MonsterViewModel()
                    MonsterLabScreen(monsterViewModel)
                }
            }
        }
    }
}

@Composable
fun MonsterLabScreen(monsterViewModel: MonsterViewModel) {
    Column(){
        Box(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
        ) {
            MonsterList(
                monstersList = monsterViewModel.monsters,
                onMonsterClicked = {newModelState -> monsterViewModel.selectedMonsterState.value = newModelState}
            )
        }
        Box(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
        ) {
            MonsterDisplay(monsterViewModel.selectedMonsterState.value)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val monsterViewModel = MonsterViewModel()
    MonsterLabTheme {
        MonsterLabScreen(monsterViewModel)
    }
}