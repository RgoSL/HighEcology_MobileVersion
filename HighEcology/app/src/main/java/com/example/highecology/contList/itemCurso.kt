package com.example.highecology.contList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.highecology.model.CursoCont
import com.example.highecology.roomDB.Curso
import com.example.highecology.rotas

@Composable
fun CursoItem(cursoCont: CursoCont, navController: NavController) {

    val imagemCurso = cursoCont.imgCurso
    val cursoNome = cursoCont.nomeCurso
    val descricaoCurso = cursoCont.desCurso
    val duracao = cursoCont.dur

    ConstraintLayout( //Constraint é Uma Biblioteca de Layout do Kotlin, Sendo Utilizada Para Fazer O Respectivo Resultado Final
        modifier = Modifier //Seus Parâmetros de Estilo
            .fillMaxWidth()
            .background(Color(0XFFE9E9E9)).padding(0.dp, 10.dp, 0.dp, 10.dp)
    ) {
        val( //Váriaveis que vão Ser Exibidas Dentro do Layout
            imgCurso,
            txtNomeCurso,
            txtDesCurso,
            txtDur,
            btnAddIni,
            containerImg,
            divCurso
        ) = createRefs() //Comando Compose Para o Entendimento que o Conteúdo Dentro do Layout é Uma Referência do Valor das Váriaveis

        Card ( //Card é o Padrão de Organização do Layout do Quadradinho
            modifier = Modifier
                .clickable {   navController.navigate(rotas.Form) }
                .constrainAs(containerImg){ //ContrainAs é um Comando Para o Programa Entender o que Será Passado Para Dentro Daquele Layout
                    //Para Dentro do Layout do Card Será Passado, Seguindo os Padrões de Layout do Constraint, a Váriavel ContainerImg, que Guarda o Valor Desse Quadradinho em Questão

                    top.linkTo(parent.top, 0.dp) //Toplink Quer Dizer que o Card Vai Ficar ALinhado ao Topo do Constraint, o "parent" Neste Caso Representa o Constraint
                    start.linkTo(parent.start, 0.dp) //Start, Simboliza o Mesmo Conceito do Top, Alinhado ao Começo Lateral do Constraint

                }
                .size(130.dp)
                .padding(20.dp),
            colors = CardDefaults.cardColors( //Refêrencia Obrigatória e Específica Para um Card Poder Receber Cores
                containerColor = Color.White
            ),
            shape = ShapeDefaults.Medium, //BorderRadius do Kotlin
            elevation =  CardDefaults.cardElevation( //Sombra no Card
                defaultElevation = 8.dp
            )
        ){

        }

        Image( //Setando Uma Imagem Para o Card

            painter = painterResource(imagemCurso!!),
            contentDescription = "Imagem Curso Biologia",
            modifier = Modifier
                .constrainAs(imgCurso){
                    top.linkTo(containerImg.top, 0.dp)
                    start.linkTo(containerImg.start, 0.dp)
                    end.linkTo(containerImg.end, 0.dp)
                    bottom.linkTo(containerImg.bottom, 0.dp)
                }
                .size(85.dp)
        )

        Text( //Setando o Título do Card

            text = cursoNome!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0XFFFF476B43),
            modifier = Modifier
                .constrainAs(txtNomeCurso){
                    top.linkTo(parent.top, 30.dp)
                    start.linkTo(containerImg.end, 0.dp)
                }
        )

        Text( //Setando a Descrição do Card

            text = descricaoCurso!!,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color(0XFFF000000),
            modifier = Modifier
                .constrainAs(txtDesCurso){
                    top.linkTo(txtNomeCurso.bottom)
                    start.linkTo(containerImg.end)
                    end.linkTo(parent.end,)
                } .padding(65.dp, 10.dp, 60.dp, 0.dp),
            maxLines = 3
        )

        Text( //Setando um Texto Para a Duração

            text = duracao!!,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color(0XFFF5A2323),
            modifier = Modifier
                .constrainAs(txtDur){
                    top.linkTo(txtDesCurso.bottom, 20.dp)
                    start.linkTo(containerImg.end, 0.dp)
                }
        )
        Button( //Setando o Botão do Card

            onClick = {

            },

            modifier = Modifier
                .height(45.dp)
                .constrainAs(btnAddIni){
                    top.linkTo(txtDesCurso.bottom, 10.dp)
                    start.linkTo(txtDur.end, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFFFF476B43)

            )
        ) {
            Text( //Texto do Botão

                text = "Começar",
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Row ( // Linha de Divisória Entre os Cards
            modifier = Modifier
                .width(360.dp)
                .height(3.dp)
                .background(Color(0XFFF5A2323))
                .constrainAs(divCurso) {
                    top.linkTo(txtDur.bottom, 30.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }

        ) {

        }
    }
}

