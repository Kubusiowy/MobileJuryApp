package com.example.jurymobileapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.OutlinedTextField



@Composable
fun logowanieJurora(navController: NavController)
{
    var imie by remember { mutableStateOf("") }
    var nazwisko by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.background(Color.LightGray).fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
        )
    {

        Text(text = "Logowanie",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(25.dp))

        TextField(
            value = imie,
            onValueChange = {imie = it},
            label = {Text(text = "Imie")},
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ikona osoby"
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Gray,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            )
        )

        Spacer(Modifier.height(15.dp))
        TextField(
            value = nazwisko,
            onValueChange = {nazwisko = it},
            label = {Text(text = "Nazwisko")},
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Ikona osoby"
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Gray,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            )

        )

        Spacer(Modifier.height(25.dp))

        Button(onClick = {






        }) {
            Text(text = "Zaloguj się")
        }

    }
}


