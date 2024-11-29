package com.example.highecology.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.highecology.roomDB.Curso
import kotlinx.coroutines.launch

class CursoViewModel(private val repository: Repository): ViewModel(){
    fun getCurso() = repository.getAllCurso().asLiveData(viewModelScope.coroutineContext)

    fun upsertCurso(curso: Curso) {
        viewModelScope.launch {
            repository.upsertCurso(curso)
        }
    }

    fun deleteCurso(curso: Curso) {
        viewModelScope.launch {
            repository.deleteCurso(curso)
        }
    }
}
