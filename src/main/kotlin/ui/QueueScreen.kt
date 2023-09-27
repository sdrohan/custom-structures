package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import datastructures.CustomQueue
import interfaces.Queue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueueScreen(queue: CustomQueue<String>) {

    var inputText by remember { mutableStateOf("") }
    var isPopupVisible by remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp))
    {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            "Queue",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        ExtendedFloatingActionButton(
            icon = { Icon(Icons.Filled.Info, contentDescription = "Info") },
            text = { Text("Info") },
            onClick = { isPopupVisible = !isPopupVisible }
        )

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter element") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                if (inputText.isNotBlank()) queue.enqueue(inputText)
                inputText = ""
            }) {
                Text("Enqueue")
            }

            Button(onClick = { queue.dequeue() }) {
                Text("Dequeue")
            }

            Button(onClick = { while (!queue.isEmpty()) queue.dequeue() }) {
                Text("Clear")
            }
        }

        Text("Queue Size: ${queue.size()}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Queue Elements:")
        Spacer(modifier = Modifier.height(8.dp))

        for (i in 0..queue.size()) {
            queue.peek(i)?.let { Text(it) }
        }

    }

    DropdownMenu(
        expanded = isPopupVisible,
        onDismissRequest = { isPopupVisible = false },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("What is a Queue?", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Add your own definition here!  \nInclude what it is, how it's used and when would you use it, with examples")
    }
}
