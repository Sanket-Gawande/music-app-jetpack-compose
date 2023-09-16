package com.example.ytm.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ytm.R
import com.example.ytm.navigator.Paths
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerBody(
	scope: CoroutineScope,
	page: MutableState<String>,
	navController: NavController,
	drawerState: DrawerState
) {
	LaunchedEffect(key1 = page.value) {
		scope.launch {
			drawerState.close()
		}

	}
	Column(
		modifier = Modifier
			.fillMaxWidth(.8f)
			.clip(RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
			.fillMaxHeight()
			.background(MaterialTheme.colorScheme.background)
	) {
		Box(
			modifier = Modifier
				.padding(0.dp, 0.dp, 0.dp, 60.dp)
				.fillMaxWidth()
				.height(150.dp)
				.background(MaterialTheme.colorScheme.primary.copy(.1f))
				.padding(0.dp, 20.dp),
			contentAlignment = Alignment.Center
		) {
			Row(
				modifier = Modifier
					.padding(20.dp)
					.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically
			) {
				Image(
					painter = painterResource(id = R.drawable.logo),
					contentDescription = null,
					modifier = Modifier.size(60.dp)
				)
				Spacer(modifier = Modifier.width(8.dp))
				Text(
					text = "YTMusic",
					style = TextStyle(
						fontSize = 40.sp,
						color = MaterialTheme.colorScheme.primary,
						fontWeight = FontWeight.Bold
					)
				)
			}
		}
		Column(
			modifier = Modifier
				.fillMaxHeight()
				.weight(1f)
		) {
			for (item in MenuItems) {

				Row(
					horizontalArrangement = Arrangement.spacedBy(10.dp),
					modifier = Modifier
						.fillMaxWidth(.85f)
						.clip(RoundedCornerShape(0.dp, 30.dp, 30.dp, 0.dp))
						.clickable {
							scope.launch {
								navController.navigate(item.label)
								page.value = item.label
							}
						}
						.background(
							if (page.value == item.label) MaterialTheme.colorScheme.primary.copy(
								.2f
							) else Color.Gray.copy(
								.2f
							)
						)
						.padding(20.dp, 15.dp)

				) {
					Icon(
						imageVector = item.icon,
						contentDescription = item.label,
						tint = if (page.value == item.label) MaterialTheme.colorScheme.primary else Color.Gray
					)
					Text(
						text = item.label, style = TextStyle(
							color = if (page.value == item.label) MaterialTheme.colorScheme.primary else Color.Gray,
							fontSize = 18.sp,

							)
					)
				}
				Spacer(modifier = Modifier.height(10.dp))
			}
		}

		Text(
			text = "V 1.x2442.F",
			modifier = Modifier
				.fillMaxWidth()
				.padding(0.dp, 20.dp),
			style = TextStyle(
				color = Color.LightGray,
				textAlign = TextAlign.Center,
				fontSize = 15.sp
			)
		)
	}
}


data class MenuItem(
	val label: String,
	val icon: ImageVector
)

var MenuItems = listOf<MenuItem>(
	MenuItem(Paths.Home.name, Icons.Default.Home),
	MenuItem(Paths.Profile.name, Icons.Default.AccountCircle),
	MenuItem(Paths.Favourites.name, Icons.Default.Favorite),
	MenuItem(Paths.Settings.name, Icons.Default.Settings),
)


