package com.example.highecology.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface CursoDAO {

    @Upsert
    suspend fun upsertCurso(curso: Curso)

    @Delete
    suspend fun deleteCurso(curso: Curso)

    @Query("SELECT * FROM Curso")
    fun getAllCurso(): Flow<List<Curso>>
}

