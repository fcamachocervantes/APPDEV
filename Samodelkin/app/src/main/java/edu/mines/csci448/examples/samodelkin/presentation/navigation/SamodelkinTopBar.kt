package edu.mines.csci448.examples.samodelkin.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import edu.mines.csci448.examples.samodelkin.presentation.navigation.specs.IScreenSpec
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel

@Composable
fun SamodelkinTopBar(
        viewModel: SamodelkinViewModel,
        navHostController: NavHostController,
        context: Context
){
    val navBackStackEntryState = navHostController.currentBackStackEntryAsState()
    IScreenSpec.TopBar(
        samodelkinViewModel = viewModel,
        navController = navHostController,
        navBackStackEntry = navBackStackEntryState.value,
        context = context
    )
}