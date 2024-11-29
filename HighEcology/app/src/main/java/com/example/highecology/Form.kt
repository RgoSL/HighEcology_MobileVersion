package com.example.highecology

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.highecology.roomDB.Curso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formCurso(navController: NavController, mainActivity: MainActivity, curso: Curso? = null) {
    var nomeCurso by rememberSaveable { mutableStateOf(curso?.nomeCurso ?: "") }
    var desCurso by rememberSaveable { mutableStateOf(curso?.desCurso ?: "") }
    var durCurso by rememberSaveable { mutableStateOf(curso?.durCurso ?: "") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFFE9E9E9))
    ) {
        // Restante do layout permanece o mesmo

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Crie, Edite ou Delete",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                color = Color(0XFFF000000)
            )

            Text(
                text = "Gerenciamento de Cursos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color(0XFFF5A8854)
            )

            Spacer(modifier = Modifier.height(58.dp))

            // Campos de entrada (TextFields)
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0XFFFB9CEB9),
                    focusedBorderColor = Color(0XFFF5A8854)
                ),
                value = nomeCurso,
                onValueChange = { nomeCurso = it },
                label = { Text(text = "Título") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(22.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0XFFFB9CEB9),
                    focusedBorderColor = Color(0XFFF5A8854)
                ),
                value = desCurso,
                onValueChange = { desCurso = it },
                label = { Text(text = "Descrição") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(22.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0XFFFB9CEB9),
                    focusedBorderColor = Color(0XFFF5A8854)
                ),
                value = durCurso,
                onValueChange = { durCurso = it },
                label = { Text(text = "Duração") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Botão de confirmação
            Button(
                modifier = Modifier
                    .height(45.dp)
                    .width(125.dp),
                shape = ShapeDefaults.Small,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFFF476B43)),
                onClick = {
                    val novoCurso = Curso(
                        nomeCurso = nomeCurso,
                        desCurso = desCurso,
                        durCurso = durCurso
                    )
                    // Lógica para salvar ou atualizar o curso
                    // Exemplo: mainActivity.saveCurso(novoCurso)
                }
            ) {
                Text(
                    text = "Confirmar",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0XFFFF2F2F2)
                )
            }
        }
    }
}