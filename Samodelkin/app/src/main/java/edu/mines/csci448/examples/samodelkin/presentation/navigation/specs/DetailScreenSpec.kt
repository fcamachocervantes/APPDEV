package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.detail.SamodelkinDetailScreen
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel
import java.util.*
import kotlin.coroutines.CoroutineContext

object DetailScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.DetailScreenSpec"

    private const val ROUTE_BASE = "detail"
    private const val ARG_UUID_NAME = "uuid"

    private fun buildFullRoute(argVal: String): String {
        var fullRoute = ROUTE_BASE
        if(argVal == ARG_UUID_NAME) {
            fullRoute += "/{$argVal}"
            Log.d(LOG_TAG, "Built base route $fullRoute")
        } else {
            fullRoute += "/$argVal"
            Log.d(LOG_TAG, "Built specific route $fullRoute")
        }
        return fullRoute
    }

    override val route = buildFullRoute(ARG_UUID_NAME)

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(ARG_UUID_NAME) {
            type = NavType.StringType
        }
    )

    override fun buildRoute(vararg args: String?): String = buildFullRoute(args[0] ?: "0")

    override val title = R.string.app_name

    @Composable
    override fun Content(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    ) {
        Log.d(LOG_TAG, "backStackEntryContents ${navBackStackEntry.arguments}")
        val uuid = navBackStackEntry.arguments?.getString("uuid")?.let{
            UUID.fromString(it)
        }
        if(uuid != null){
            samodelkinViewModel.loadCharacterByUUID(uuid)
        }
        val character = samodelkinViewModel.currentCharacterState.collectAsState().value

        if(character != null){
            SamodelkinDetailScreen(
                character = character
            )
        }
    }

    @Composable
    override fun TopAppBarActions(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ) {
        val uuid = navBackStackEntry?.arguments?.getString("uuid")?.let{
            UUID.fromString(it)
        }
        samodelkinViewModel.loadCharacterByUUID(uuid!!)
        val character = samodelkinViewModel.currentCharacterState.collectAsState().value

        IconButton(onClick = {
                samodelkinViewModel.deleteCharacter(character!!)
                navController.popBackStack(route = ListScreenSpec.buildRoute(), inclusive = false)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = stringResource(id = R.string.menu_delete_character_desc)
            )
        }
    }

}