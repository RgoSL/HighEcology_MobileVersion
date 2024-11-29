package com.example.highecology.viewModel

import com.example.highecology.roomDB.Curso
import com.example.highecology.roomDB.CursoDatabase

class Repository (private val db : CursoDatabase){
    suspend fun upsertCurso(curso: Curso) {
        db.cursoDao().upserCurso(curso)
    }

    suspend fun deleteCurso(curso: Curso) {
        db.cursoDao().deleteCurso(curso)
    }

    fun getAllCurso() = db.cursoDao().getAllCurso()
}