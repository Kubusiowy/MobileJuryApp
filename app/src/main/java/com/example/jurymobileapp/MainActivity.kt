package com.example.jurymobileapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

import androidx.navigation.compose.rememberNavController
import com.example.jurymobileapp.navigation.setNavHosts


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        WindowCompat.setDecorFitsSystemWindows(window, true)

        // Ustawienie jasnych ikon (true = ciemne ikony na jasnym tle)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightStatusBars = true

        // Kolor tła status bara – biały
        window.statusBarColor = Color.RED
        setContent {
        val navController = rememberNavController()
            setNavHosts(navController)

        }
    }
}

