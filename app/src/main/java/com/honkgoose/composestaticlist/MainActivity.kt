package com.honkgoose.composestaticlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honkgoose.composestaticlist.ui.theme.ComposeStaticListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStaticListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoList()
                }
            }
        }
    }
}

@Composable
fun TodoList() {
    var name by remember { mutableStateOf("") }
    val names by remember { mutableStateOf(emptyList<String>()) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp, 16.dp, 16.dp, 16.dp)
                    .weight(1f),
                onValueChange = { text -> name = text },
                value = name
            )
            Button(
                modifier = Modifier
                    .padding(0.dp, 16.dp, 16.dp, 16.dp)
                    .wrapContentSize(),
                onClick = {
                    if (name.isNotBlank()) {
                        names + name
                        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
                        name = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStaticListTheme {
        TodoList()
    }
}