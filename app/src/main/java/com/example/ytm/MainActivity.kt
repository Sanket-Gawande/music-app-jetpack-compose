package com.example.ytm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.ytm.Components.DrawerBody
import com.example.ytm.navigator.Navigation
import com.example.ytm.navigator.Paths
import com.example.ytm.ui.theme.YTMTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			YTMTheme {
				var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
				var scope = rememberCoroutineScope()
				var page = remember {
					mutableStateOf("Home")
				}
				var navController = rememberNavController()

				ModalNavigationDrawer(
					gesturesEnabled = drawerState.isOpen,
					drawerState = drawerState,
					scrimColor = Color.Black.copy(alpha = 0.5f),
					drawerContent = { DrawerBody(scope = scope, page = page, navController, drawerState) }
				) {
					Scaffold(
						modifier = Modifier.fillMaxWidth(),
						topBar = {
							Row(
								modifier = Modifier
									.fillMaxWidth()
									.background(MaterialTheme.colorScheme.primary.copy(0.1f))
									.padding(20.dp, 10.dp),
								horizontalArrangement = Arrangement.SpaceBetween,
								verticalAlignment = Alignment.CenterVertically
							) {
								Image(
									painter = painterResource(id = R.drawable.logo),
									contentDescription = null,
									modifier = Modifier.size(40.dp)
										.clip(CircleShape)
										.clickable {
											scope.launch {
												navController.navigate(Paths.Home.name)
											}
										}
								)
								Text(
									text = "YTMusic", style = TextStyle(
										color = MaterialTheme.colorScheme.primary,
										fontSize = 20.sp,
										fontWeight = FontWeight.SemiBold
									)
								)
								IconButton(
									modifier = Modifier
										.size(35.dp)
										.clip(CircleShape)
										.padding(1.dp)
										.background(MaterialTheme.colorScheme.primary.copy(.1f)),
									onClick = {
										scope.launch {
											drawerState.open()
										}

									}) {
									Icon(
										imageVector = Icons.Default.Menu,
										contentDescription = null,
										modifier = Modifier.size(20.dp)
									)
								}
							}
						},
					) {
						Column(
							modifier = Modifier
								.padding(paddingValues = it)
								.fillMaxHeight()
						) {
							Navigation(
								controller = navController,
							)
						}
					}

				}

			}
		}
	}
}


val categories = arrayOf(
	"Pop",
	"Rock",
	"Hip-Hop/Rap",
	"R&B",
	"Country",
	"Electronic",
	"Jazz",
	"Classical",
	"Reggae",
	"Blues"
)
