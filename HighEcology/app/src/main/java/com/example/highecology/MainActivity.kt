package com.example.highecology

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.highecology.contList.CursoItem
import com.example.highecology.model.Curso

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //TelaLogin()
        CursoList()
        }
    }
}


@Composable
private fun CursoList(){ //Essa Classe Composable é Usada Para Exibir o Agrupamento dos Itens que Compôe o Card

    val listaCurso: MutableList<Curso> = mutableListOf(
        Curso(
        imgCurso = R.drawable.biologia,
            nomeCurso = "Biologia",
            desCurso = "Biologia é a ciência natural que estuda os organismos vivos",
            dur = "60 Minutos"
        ),

        Curso(
            imgCurso = R.drawable.sustentabilidade,
            nomeCurso = "Sustentabilidade",
            desCurso = "É o estudo do conceito de equilibrio entre o avanço humano e a preservação natural",
            dur = "165 Minutos"
        ),

        Curso(
            imgCurso = R.drawable.oceanografia,
            nomeCurso = "Oceanografia",
            desCurso = "Oceanografia é o estudo dos oceanos e zonas costeiras",
            dur = "155 Minutos"
        ),

        Curso(
            imgCurso = R.drawable.ecologia,
            nomeCurso = "Ecologia",
            desCurso = "Ecologia é o estudo do meio ambiente e os seres que habitam nele",
            dur = "215 Minutos"
        ),

        Curso(
            imgCurso = R.drawable.silvicultura,
            nomeCurso = "Silvicultura",
            desCurso = "Silvicultura é o estudo do manejo florestal, focando em um consumo consciente",
            dur = "105 Minutos"
        )

    )

    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
    ) {

        // Comando Utilizado Para Setar o Layout de Lista aos Elementos, Quando For Necessário Organizar Várias Coisas em um Mesmo Formato, Utilizasse o Lazy
        LazyColumn {
        itemsIndexed(listaCurso){_, curso -> // Indexed Anexa os Itens que eu Quero, Passo a Váriavel que Recebe os Valores Para Listar
            //Position é Para Abrigar Eles Aqui, Curso é a Classe Com os Valores a Serem Passados

            CursoItem(curso) // Função Com o Card Recebe a Classe Com os Dados Como Parâmetro

          }
        }

    }
}

@Composable
@Preview

fun adoado(){
    CursoList()
}





