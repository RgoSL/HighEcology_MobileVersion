package com.example.highecology.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Curso::class],
     version = 1
)

abstract class CursoDatabase: RoomDatabase() {
    abstract fun cursoDao(): CursoDAO
}