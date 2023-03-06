package com.csci448.fcamachocervantes.monsterlab.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.csci448.fcamachocervantes.monsterlab.data.Monster
import com.csci448.fcamachocervantes.monsterlab.data.MonsterRepo

class MonsterViewModel {
    val selectedMonsterState: MutableState<Monster?> = mutableStateOf(null)
    val monsters: List<Monster> = MonsterRepo.monsters

}