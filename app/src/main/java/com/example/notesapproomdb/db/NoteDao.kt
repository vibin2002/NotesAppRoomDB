package com.example.notesapproomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note :Note)

    @Query("SELECT * FROM NOTE ORDER BY ID DESC")
    suspend fun getAllNotes() :List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Update
    suspend fun updateNotes(note: Note)

}