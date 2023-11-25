package com.main.stateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.stateexample.ui.theme.StateExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(count: Int, onIncrement: () -> Unit, onReset: () -> Unit, modifier: Modifier = Modifier)
{
    Column(modifier=modifier.padding(16.dp)) {
        if (count > 0){
            var showTask by rememberSaveable {
                mutableStateOf(true)
            }
            var checked by rememberSaveable {
                mutableStateOf(false);
            }
            if(showTask){
                WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?",
                         checked=checked,onClose = { showTask = false }, onCheckedChange = {checked = !checked},
                    modifier)
            }

            Text(
                text = "You've had $count glasses.",
                modifier=modifier.padding(16.dp)
            )
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = onIncrement, enabled = count <10) {
                Text("Add one")
            }
            Button(onClick = onReset,
                modifier= modifier.padding(start=8.dp)) {
                Text("Clear water count")
            }
        }
        

    }

}
