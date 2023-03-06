package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel

sealed interface IScreenSpec {
    companion object {
        private const val LOG_TAG = "448.IScreenSpec"

        val allScreens = IScreenSpec::class.sealedSubclasses.associate {
            Log.d(LOG_TAG, "allScreens: mapping route \"${it.objectInstance?.route ?: ""}\" to object \"${it.objectInstance}\"")
            it.objectInstance?.route to it.objectInstance
        }
        const val root = "samodelkin"
        val startDestination = ListScreenSpec.route

        @Composable
        fun TopBar(
            samodelkinViewModel: SamodelkinViewModel,
            navController: NavHostController,
            navBackStackEntry: NavBackStackEntry?,
            context: Context
        ){
            val route = navBackStackEntry?.destination?.route ?: ""
            allScreens[route]?.TopAppBarContent(
                samodelkinViewModel, navController, navBackStackEntry, context
            )
        }
    }

    val route: String
    val title: Int
    val arguments: List<NamedNavArgument>
    fun buildRoute(vararg args: String?): String

    @Composable
    fun Content(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopAppBarContent(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ){
        TopAppBar(
            navigationIcon = if (navController.previousBackStackEntry != null) {
                {
                    IconButton(onClick = {navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.menu_back_desc)
                        )
                    }
                }
            } else {
                { }
            },
            title = {
                Text(text = stringResource(id = title))
            },
            actions = {
                TopAppBarActions(
                    samodelkinViewModel = samodelkinViewModel,
                    navController = navController,
                    navBackStackEntry = navBackStackEntry,
                    context = context
                )
            }
        )
    }

    @Composable
    fun TopAppBarActions(
        samodelkinViewModel: SamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    )
}