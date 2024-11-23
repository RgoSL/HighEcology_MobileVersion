package com.example.highecology

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun formCurso(){

    Column(
        modifier = Modifier.fillMaxSize()

            .background(Color(0XFFFE9E9E9)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier
            .padding(0.dp , 40.dp, 0.dp, 0.dp),
            text = "Gerenciamento de Cursos",
            fontSize = 28.sp,
            fontFamily = FontFamily.Serif,
          color =  Color(0XFFFF476B43),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Crie, Edite ou Delete",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {
                ""
            }, label = {
                Text(
                    text = "Título"
                )
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = "" ,
            onValueChange = {
               ""
            }, label = {
                Text(
                    text = "Descrição"
                )
            }, visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = "" ,
            onValueChange = {
                ""
            }, label = {
                Text(
                    text = "Duração"
                )
            }
        )


        Spacer(modifier = Modifier.height(50.dp))

        Button(
            modifier = Modifier
                .height(45.dp)
                .width(120.dp),
            shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFFF476B43))

                ,
            onClick = {

        }

        ) {
            Text(
                text = "Concluir",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }


        Spacer(modifier = Modifier.height(32.dp))

    }

}



@Composable
@Preview

fun formCursoPreview(){
    formCurso()
}