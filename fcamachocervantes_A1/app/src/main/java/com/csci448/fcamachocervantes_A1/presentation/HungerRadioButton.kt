package com.csci448.fcamachocervantes_A1.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.fcamachocervantes_A1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HungerRadioButton(hungerList: List<String>,
                      selectedHungerState: String,
                      onHungerStateSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Text(
            stringResource(id = R.string.how_hungry_label)
        )
        Row(
            modifier = Modifier
                .selectableGroup()
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            hungerList.forEach { label ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (selectedHungerState == label),
                            onClick = { onHungerStateSelected(label) },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier.padding(end = 16.dp),
                        selected = (selectedHungerState == label),
                        onClick = null
                    )
                    Text(text = label)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHungerRadioButton() {
    val list = listOf("Light", "Medium", "Ravenous")
    val hungerState = list[0]
    HungerRadioButton(hungerList = list, hungerState, {})
}