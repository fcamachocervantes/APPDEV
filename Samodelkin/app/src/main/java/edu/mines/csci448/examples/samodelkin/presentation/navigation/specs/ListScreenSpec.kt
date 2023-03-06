package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.detail.SamodelkinDetailScreen
import edu.mines.csci448.examples.samodelkin.presentation.list.SamodelkinListScreen
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel
import java.util.*

object ListScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.ListScreenSpec"

    override val route = "list"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route
    override val title = R.string.app_name

    @Composable
    override fun Content(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        Log.d(ListScreenSpec.LOG_TAG, "ListScreenSpec Displaying")
        SamodelkinListScreen(
            characterList = samodelkinViewModel.characters,
            onSelectCharacter = {

                Log.d(ListScreenSpec.LOG_TAG, "onSelectCharacterCalled")
                navController.navigate(route = DetailScreenSpec.buildRoute("${it.id}"))
            }
        )
    }

    @Composable
    override fun TopAppBarActions(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ) {
        IconButton(onClick = { navController.navigate(NewCharacterScreenSpec.route) }) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = stringResource(id = R.string.menu_add_character_desc)
            )
        }
    }

}