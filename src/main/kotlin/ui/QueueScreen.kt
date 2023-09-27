package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import datastructures.CustomQueue
import interfaces.Queue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueueScreen(queue: CustomQueue<String>) {

    var inputText by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp))
    {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            "Queue",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
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

        for(i in 0..queue.size()){
            queue.peek(i)?.let { Text(it) }
        }

    }
}
