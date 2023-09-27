package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import interfaces.LinkedList

@Composable
fun LinkedListScreen(list: LinkedList<String>) {

    val listSize by remember { mutableStateOf(list.size()) }

    Column(Modifier.padding(16.dp))
    {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            "Singly Linked List",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("List Size: $listSize")

        Spacer(modifier = Modifier.height(8.dp))
        Text("List Elements:")
    }
}