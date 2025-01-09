package com.example.notepadapp

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("editor") { NoteEditorScreen(navController) }
    }
}
