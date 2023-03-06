package edu.mines.csci448.examples.samodelkin.presentation.viewmodel

import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

interface ISamodelkinViewModel {
    val characterListState: StateFlow<List<SamodelkinCharacter>>
    val currentCharacterState: StateFlow<SamodelkinCharacter?>
    fun loadCharacterByUUID(uuid: UUID)
    fun addCharacter(samodelkinCharacter: SamodelkinCharacter)
    fun deleteCharacter(samodelkinCharacter: SamodelkinCharacter)
}