package com.example.jurymobileapp.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jurymobileapp.data.GetDaneViewModel
import com.example.jurymobileapp.data.OcenyViewModel
import com.example.jurymobileapp.model.Juror
import com.example.jurymobileapp.model.Kategoria
import com.example.jurymobileapp.model.Kryterium
import com.example.jurymobileapp.model.OcenaRequest
import com.example.jurymobileapp.model.Uczestnik

@Composable
fun OcenaScreen(
    navController: NavController,
    uczestnikId: Int,
    jurorId: Int,
    kategoriaId: Int,
    viewModel: GetDaneViewModel,
    ocenyViewModel: OcenyViewModel
) {
    val uczestnik = viewModel.uczestnicy.find { it.id == uczestnikId }
    val kategoria = viewModel.kategorie.find { it.id == kategoriaId }
    val kryteria = viewModel.kryteria.filter { it.idKategorii == kategoriaId }

    val context = LocalContext.current

    val oceny = remember { mutableStateMapOf<Int, String>() }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Oceniasz: ${uczestnik?.imie} ${uczestnik?.nazwisko}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text("Kategoria: ${kategoria?.nazwa}", fontSize = 16.sp)

        Spacer(modifier = Modifier.padding(8.dp))

        LazyColumn {
            items(kryteria.size) { index ->
                val kryterium = kryteria[index]
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    Row(modifier = Modifier.padding(bottom = 4.dp)) {
                        Text(
                            text = kryterium.nazwa,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                        TextField(
                            value = oceny[kryterium.id] ?: "",
                            onValueChange = { newValue ->
                                oceny[kryterium.id] = newValue
                            },
                            modifier = Modifier.weight(1f),
                            label = { Text("0–${kryterium.maksPunkty}") }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                var danePoprawne = true

                kryteria.forEach { kryterium ->
                    val tekst = oceny[kryterium.id]
                    val wartosc = tekst?.toIntOrNull()

                    if (wartosc == null || wartosc < 1 || wartosc > kryterium.maksPunkty) {
                        danePoprawne = false
                        Toast.makeText(
                            context,
                            "Błąd w kryterium: ${kryterium.nazwa}. Wprowadź wartość od 1 do ${kryterium.maksPunkty}",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@Button
                    }
                }

                if (!danePoprawne) {
                    return@Button
                }

                oceny.forEach { (kryteriumId, ocenaText) ->
                    val wartosc = ocenaText.toIntOrNull()
                    val maks = kryteria.find { it.id == kryteriumId }?.maksPunkty ?: 10

                    if (wartosc != null && wartosc in 1..maks) {
                        val request = OcenaRequest(
                            juryId = jurorId,
                            uczestnikId = uczestnikId,
                            kryteriumId = kryteriumId,
                            wartosc = wartosc
                        )
                        ocenyViewModel.wyslijOcene(request)
                    }
                }

                Toast.makeText(context, "Oceny zostały zapisane 🎉", Toast.LENGTH_SHORT).show()

                navController.popBackStack()

            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Zapisz oceny")
        }
    }
}
