package com.example.highecology

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(navController: NavController){

    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0XFFFE9E9E9)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
   Image(painter = painterResource(id = R.drawable.logo_dois), contentDescription = "High Ecology Logo",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Pode Entrar!",
            fontSize = 28.sp,
            color = Color(0XFFF5A2323),
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Entre na Sua Conta",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0XFFFB9CEB9),
                focusedBorderColor = Color(0XFFF5A8854)
            ),
            value = email,
            onValueChange = {
                email = it
            }, label = {
                Text(
                    text = "Email"

                )
            }
        )

        Spacer(modifier = Modifier.height(22.dp))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0XFFFB9CEB9),
                focusedBorderColor = Color(0XFFF5A8854)
            ),
            value = senha ,
            onValueChange = {
                senha = it
            }, label = {
                Text(
                    text = "Senha"
                )
            }, visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier
                .height(45.dp)
                .width(120.dp),
            shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFFF476B43))
            ,

            onClick = {
                Log.i("Dados", "Email : $email Senha : $senha")
                navController.navigate(rotas.Cursos)
            } ) {
            Text(
                text = "Entrar"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

    }

}


