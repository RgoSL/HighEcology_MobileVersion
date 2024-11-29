package com.example.highecology

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.highecology.roomDB.CursoDatabase
import com.example.highecology.ui.theme.HighEcologyTheme
import com.example.highecology.viewModel.CursoViewModel
import com.example.highecology.viewModel.Repository

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            CursoDatabase::class.java,
            "CareTones.db"
        ).build()
    }

    private val CursoViewModel by viewModels<CursoViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CursoViewModel(Repository(db)) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

           HighEcologyTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = rotas.Login, builder = {
                        composable(rotas.Cursos){
                            TelaLogin(navController)
                        }
                        composable(rotas.Form){
                         formCurso(navController, mainActivity = this@MainActivity)
                        }
                    })
                }
            }
        }
    }
}