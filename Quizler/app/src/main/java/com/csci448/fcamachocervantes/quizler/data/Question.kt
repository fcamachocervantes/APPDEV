package com.csci448.fcamachocervantes.quizler.data

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import com.csci448.fcamachocervantes.quizler.R

data class Question(@StringRes val questionTextId: Int,
                    val correctChoiceNumber: Int,
                    @StringRes val choice1Id: Int = R.string.label_true,
                    @StringRes val choice2Id: Int = R.string.label_false,
                    @StringRes val choice3Id: Int? = null,
                    @StringRes val choice4Id: Int? = null){

}
