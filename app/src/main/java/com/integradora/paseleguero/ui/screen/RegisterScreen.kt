package com.integradora.paseleguero.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.integradora.paseleguero.ui.buttons.InputText
import com.integradora.paseleguero.ui.buttons.PrimaryButton
import com.integradora.paseleguero.ui.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(25.dp)
    ) {

        Text(
            text = "Registro",
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
        )
        val viewModel: RegisterViewModel = viewModel()
        InputText(
            value = viewModel.username.value,
            onValueChange = { viewModel.username.value = it },
            text = "Usuario",
        )
        InputText(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            text = "Correo",
        )
        InputText(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            text = "Contraseña",
        )
        InputText(
            value = viewModel.fechaNacimiento.value,
            onValueChange = { viewModel.fechaNacimiento.value = it },
            text = "Fecha de nacimiento",
        )
        InputText(
            value = viewModel.telefono.value,
            onValueChange = { viewModel.telefono.value = it },
            text = "Teléfono",
        )
        PrimaryButton("Aceptar",) {
            viewModel.register {
                navController.navigate("login") {
                    popUpTo("register") { inclusive = true }
                }
            }
        }

    }
}