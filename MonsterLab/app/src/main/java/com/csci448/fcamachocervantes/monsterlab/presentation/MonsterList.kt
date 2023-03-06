package com.csci448.fcamachocervantes.monsterlab.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.csci448.fcamachocervantes.monsterlab.data.Monster
import com.csci448.fcamachocervantes.monsterlab.data.MonsterRepo

@Composable
fun MonsterList(monstersList: List<Monster>,
                onMonsterClicked: (Monster) -> Unit) {
    LazyColumn{
        items(monstersList) {monster ->
            MonsterCard(monster, onMonsterClicked)
        }
    }
}

@Preview
@Composable
fun PreviewMonsterList() {
    MonsterList(MonsterRepo.monsters, onMonsterClicked = {})
}