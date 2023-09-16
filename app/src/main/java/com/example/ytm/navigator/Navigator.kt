package com.example.ytm.navigator

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ytm.Screens.HomeScreen
import com.example.ytm.Screens.ProfileScreen
import com.example.ytm.Screens.SettingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
	controller: NavHostController,
) {
	NavHost(navController = controller, startDestination = Paths.Home.name) {
		composable(Paths.Home.name) {
			HomeScreen()
		}

		composable(Paths.Profile.name) {
			ProfileScreen()
		}

		composable(Paths.Settings.name) {
			SettingScreen()
		}

		composable(Paths.Favourites.name) {
			ProfileScreen()
		}
	}
}

enum class Paths {
	Home, Settings, Profile, Favourites
}