package com.example.notepadapp

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM Note")
    suspend fun getAllNotes(): List<Note>
}
