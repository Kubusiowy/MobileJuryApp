package com.example.jurymobileapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jurymobileapp.data.GetDaneViewModel
import com.example.jurymobileapp.model.Juror
import com.example.jurymobileapp.model.Kategoria
import com.example.jurymobileapp.model.Kryterium
import com.example.jurymobileapp.model.Uczestnik

@Composable
fun OcenaScreen(navController: NavController, uczestnikId: Int, jurorId: Int, kategoriaId: Int, viewModel: GetDaneViewModel) {

    val uczestnik = viewModel.uczestnicy.find {it.id == uczestnikId}
    val kategoria = viewModel.kategorie.find { it.id == kategoriaId }
    val kryteria = viewModel.kryteria.filter { it.idKategorii == kategoriaId }

    val oceny = remember { mutableStateMapOf<Int, String>() }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Oceniasz: ${uczestnik?.imie} ${uczestnik?.nazwisko}", fontSize = 20.sp)
        Text("Kategoria: ${kategoria?.nazwa}")
        Row()
        {
            Text("Uczestnik: ${uczestnik?.imie} ")
            Text("${uczestnik?.nazwisko}")
        }


        Spacer(modifier = Modifier.padding(8.dp))

        kryteria.forEach { kryterium ->
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text("Kryterium: ${kryterium.nazwa}", fontWeight = FontWeight.Bold)

                TextField(
                    value = oceny[kryterium.id] ?: "",
                    onValueChange = { newValue ->
                        oceny[kryterium.id] = newValue
                    },
                    label = { Text("Wpisz ocenę (0-10)") }
                )
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {
            oceny.forEach { (kryteriumId, ocenaText) ->
                println("Kryterium $kryteriumId: ocena = $ocenaText")

            }
        }) {
            Text("Zapisz oceny")
        }
    }

}