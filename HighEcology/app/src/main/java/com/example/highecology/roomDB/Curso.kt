package com.example.highecology.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Curso(
    val nomeCurso: String,
    val desCurso: String,
    val durCurso: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
