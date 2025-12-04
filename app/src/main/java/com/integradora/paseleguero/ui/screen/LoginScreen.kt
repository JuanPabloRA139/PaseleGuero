package com.integradora.paseleguero.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.InputText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.integradora.paseleguero.R
import com.integradora.paseleguero.ui.buttons.InputText
import com.integradora.paseleguero.ui.buttons.Link
import com.integradora.paseleguero.ui.buttons.PrimaryButton
import com.integradora.paseleguero.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(R.drawable.logo),
            contentDescription = "Dely",
            modifier = Modifier
                .padding(0.dp)
                .width(420.dp)
                .height(320.dp))
        Text(text = "Inicio de sesión",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        InputText(
            value = viewModel.username.value,
            onValueChange = { viewModel.username.value = it },
            text = "Usuario"
        )
        Spacer(Modifier.height(20.dp))
        InputText(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            text = "Contraseña"
        )
        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        PrimaryButton("Aceptar",) {
            viewModel.login {
                navController.navigate("menu") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Link("¿Perdiste tu contraseña?") {
            navController.navigate("forgot_password")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Link("¿Aún no te has registrado?") {
            navController.navigate("register")
        }
    }
}