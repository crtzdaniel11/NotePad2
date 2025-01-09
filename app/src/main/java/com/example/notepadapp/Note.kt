package com.example.notepadapp

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)
