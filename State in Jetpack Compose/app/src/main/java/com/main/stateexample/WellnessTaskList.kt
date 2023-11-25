package com.main.stateexample

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier


@Composable
fun WellnessTasksList(
    modifier: Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChange: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ){
        items(
            items=list,
            key = {task-> task.id}) {
            task -> 
                WellnessTaskItem(
                    taskName = task.label,
                    onCloseTask = { onCloseTask(task) },
                    task.checked,
                    { checked -> onCheckedChange(task, checked) },
                    modifier
                )
        }
    }
}



