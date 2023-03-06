package edu.mines.csci448.examples.tempconverter.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.mines.csci448.examples.tempconverter.R

@Composable
fun ConvertScreen(temperatureViewModel: TemperatureViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.sunrise),
            contentDescription = stringResource(id = R.string.sunrise_image_description),
            modifier = Modifier
                .height(180.dp)
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        EnterTemperatureBox(
            tempText = temperatureViewModel.celsiusStringState.value,
            onNewTempValue = {newCelsiusString ->
                temperatureViewModel.setNewCelsiusString(newCelsiusString)
            }
        )

        Row {
            val context = LocalContext.current
            ConvertButton {
                if( !temperatureViewModel.convertToFahrenheit() )
                    Toast.makeText(context,
                        R.string.message_invalid_input,
                        Toast.LENGTH_SHORT)
                        .show()
            }
        }

        TemperatureText(
            celsius = temperatureViewModel.celsiusState.value,
            fahrenheit = temperatureViewModel.fahrenheitState.value
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewConvertScreen() {
    ConvertScreen(TemperatureViewModel())
}