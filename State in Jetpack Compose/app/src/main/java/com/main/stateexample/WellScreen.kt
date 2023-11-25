package com.main.stateexample

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier= Modifier) {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    val wellnessViewModel = WellnessViewModel()

    Column(modifier = modifier) {
        WaterCounter(counter, {counter ++}, {counter = 0}, modifier)
        WellnessTasksList(modifier = modifier,
            wellnessViewModel.tasks,
            onCloseTask = {task -> wellnessViewModel.remove(task)},
            {task, checked -> wellnessViewModel.changeCheckedState(task, checked)}

        )

    }
}

