package com.csci448.fcamachocervantes.monsterlab.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.fcamachocervantes.monsterlab.data.Monster
import com.csci448.fcamachocervantes.monsterlab.R
import com.csci448.fcamachocervantes.monsterlab.data.MonsterRepo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonsterDisplay(monster: Monster?) {
    if(monster != null)
    {
        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = monster.imageId),
                    contentDescription = stringResource(id = monster.nameId)
                )
                Column(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = stringResource(id = monster.nameId),
                        fontSize = 28.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = stringResource(id = monster.descId),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
    else
    {
        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.null_monster),
                        fontSize = 28.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMonsterDisplay() {

    val monsterList = MonsterRepo.monsters
    val youngMike = monsterList[0]
    MonsterDisplay(monster = youngMike)
}

@Preview
@Composable
fun PreviewMonsterDisplay2() {
    val donCarlton = null
    MonsterDisplay(monster = donCarlton)
}

