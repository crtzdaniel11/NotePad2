package com.example.notepadapp

@Composable
fun MainScreen(navController: NavHostController) {
    val notes = remember { mutableStateListOf("Sample Note 1", "Sample Note 2") }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Notepad") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("editor")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) {
        LazyColumn {
            items(notes) { note ->
                Text(note, Modifier.padding(16.dp))
            }
        }
    }
}
