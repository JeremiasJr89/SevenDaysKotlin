package com.example.authentic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.authentic.ui.theme.SevenDaysKotlinTheme

class Authentic : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenDaysKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen() {
    Column {
        //configuracao de pegar o valor digitado para o campo. criacao da variavel mutavel, e depois no texfield recebo os novos valores digitados
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(value = password,
            onValueChange = {
                password = it
            }, visualTransformation = PasswordVisualTransformation()
        )
        TextField(value = username,
            onValueChange = { newUser ->
            username = newUser
        })
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Entrar")
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    SevenDaysKotlinTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

        }
        AuthScreen()
    }
}