package com.example.jurymobileapp.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.jurymobileapp.data.GetDaneViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jurymobileapp.model.Uczestnik


@Composable
fun WyborUczestnika(navController: NavController, viewModel: GetDaneViewModel,jurorId:Int,kategoriaId: Int)
{
    val uczestnicy = viewModel.uczestnicy
    val kategoria = viewModel.kategorie.find { it.id == kategoriaId }
    val juror = viewModel.zalogowanyJuror

    Column(modifier = Modifier.fillMaxSize())
    {
        Row(modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(start = 14.dp, end = 14.dp, top = 20.dp, bottom = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = kategoria?.nazwa?: "nieznana",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)
        }


        listUczestnicy(uczestnicy,navController)

    }
}

@Composable
fun listUczestnicy(uczestnicy: List<Uczestnik>,navController: NavController) {

    LazyColumn {
        items(uczestnicy) { uczestnik ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {

                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Imię: ${uczestnik.imie}")
                    Text("Nazwisko: ${uczestnik.nazwisko}")
                    Text("ID: ${uczestnik.id}")
                }
            }
        }
    }
}
