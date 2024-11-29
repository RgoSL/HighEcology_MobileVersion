package com.example.highecology


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.highecology.contList.CursoItem
import com.example.highecology.model.CursoCont
import com.example.highecology.roomDB.Curso

@Composable
private fun CursoList(curso: Curso? = null){ //Essa Classe Composable é Usada Para Exibir o Agrupamento dos Itens que Compôe o Card

    val listaCurso: MutableList<CursoCont> = mutableListOf(
        CursoCont(
            imgCurso = R.drawable.biologia,
            nomeCurso = curso?.nomeCurso,
            desCurso = curso?.desCurso,
            dur = curso?.durCurso
        ),

        CursoCont(
            imgCurso = R.drawable.sustentabilidade,
            nomeCurso = curso?.nomeCurso,
            desCurso = curso?.desCurso,
            dur = curso?.durCurso
        ),

        CursoCont(
            imgCurso = R.drawable.oceanografia,
            nomeCurso = curso?.nomeCurso,
            desCurso = curso?.desCurso,
            dur = curso?.durCurso
        ),

        CursoCont(
            imgCurso = R.drawable.ecologia,
            nomeCurso = curso?.nomeCurso,
            desCurso = curso?.desCurso,
            dur = curso?.durCurso
        ),

        CursoCont(
            imgCurso = R.drawable.silvicultura,
            nomeCurso = curso?.nomeCurso,
            desCurso = curso?.desCurso,
            dur = curso?.durCurso
        )

    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        // Comando Utilizado Para Setar o Layout de Lista aos Elementos, Quando For Necessário Organizar Várias Coisas em um Mesmo Formato, Utilizasse o Lazy
        LazyColumn {
            itemsIndexed(listaCurso){_, curso -> // Indexed Anexa os Itens que eu Quero, Passo a Váriavel que Recebe os Valores Para Listar
                //Position é Para Abrigar Eles Aqui, Curso é a Classe Com os Valores a Serem Passados

                CursoItem(
                    curso,
                    navController = TODO()
                ) // Função Com o Card Recebe a Classe Com os Dados Como Parâmetro

            }
        }

    }
}

