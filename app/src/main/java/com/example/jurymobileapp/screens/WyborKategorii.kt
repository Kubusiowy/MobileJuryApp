package com.example.jurymobileapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jurymobileapp.data.GetDaneViewModel
import com.example.jurymobileapp.items.SetLightStatusBar
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.shadow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jurymobileapp.data.Screens
import com.example.jurymobileapp.model.Kategoria

@Composable
fun wyborKategorii(navController: NavController,viewModel: GetDaneViewModel) {


        val juror = viewModel.zalogowanyJuror

    Column(modifier = Modifier.fillMaxSize())
    {
        Row(modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(start = 14.dp, end = 14.dp, top = 20.dp, bottom = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            )
        {
            Text(text = "Juror: ${juror?.imie?: "brak"} ${juror?.nazwisko?: "brak"}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)
        }


        ListaKategori(viewModel,navController)

    }

}

@Composable
fun ListaKategori(viewModel: GetDaneViewModel,navController: NavController){
    val kategorie = viewModel.kategorie

    LazyColumn(Modifier.fillMaxSize().padding(12.dp)) {

        items(kategorie) {kategoria ->

            KategoriaCard(kategoria,navController,viewModel)
            Spacer(modifier = Modifier.height(16.dp))

        }

    }
}


@Composable
fun KategoriaCard(kategoria: Kategoria,navController: NavController,viewModel: GetDaneViewModel)
{

    val juror = viewModel.zalogowanyJuror

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp).clickable{

                juror?.let {
                    navController.navigate(Screens.WyborUczestnikow.passIds(it.id, kategoria.id))
                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE3F2FD)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = kategoria.nazwa,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "ID: ${kategoria.id}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}