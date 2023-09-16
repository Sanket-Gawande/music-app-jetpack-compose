package com.example.ytm.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ytm.R

@Composable
fun ProfileScreen() {
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.fillMaxHeight()
		) {

	//photo and cover box
			Box(
				modifier = Modifier
					.fillMaxHeight(.3f)
					.fillMaxWidth()
			) {
				Box(
					modifier = Modifier
						.fillMaxHeight(.5F)
						.fillMaxWidth()
				) {
					Image(
						painter = painterResource(id = R.drawable.cover),
						contentDescription = null,
						modifier = Modifier.fillMaxSize(),
						contentScale = ContentScale.Crop
					)
					Box(
						modifier = Modifier
							.fillMaxSize()
							.background(MaterialTheme.colorScheme.primary.copy(.5f))
					)
				}
				Column(
					modifier = Modifier
						.fillMaxHeight()
						.fillMaxWidth(),
					verticalArrangement = Arrangement.Bottom,
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Image(
						painter = painterResource(id = R.drawable.fish),
						contentDescription = null,
						modifier = Modifier
							.size(140.dp)
							.clip(CircleShape)
							.background(MaterialTheme.colorScheme.primary)
							.padding(3.dp)
							.clip(CircleShape)
							.background(MaterialTheme.colorScheme.primary)
					)
					Text(
						text = "Mr. Android 13.0",
						modifier = Modifier.padding(0.dp, 5.dp),
						style = TextStyle(
							fontSize = 20.sp,
							fontWeight = FontWeight.SemiBold,
							color = MaterialTheme.colorScheme.primary
						)
					)
					Text(
						text = "YTM With material 3",
						style = TextStyle(
							fontSize = 15.sp,
							color = MaterialTheme.colorScheme.secondary.copy(.6f)
						)
					)
				}
			}

			Spacer(modifier = Modifier.height(20.dp))
			// name and other info
			TextGroup("Name", "Sanket Gawande")
			TextGroup("Email", "sanket@rsquarewebstudio.com")
			TextGroup("Phone", "+91 7030621543")
			TextGroup("About", "Learning android developement with Kotlin-Jetpack Compose")

			Spacer(modifier = Modifier.fillMaxHeight().weight(1f))
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.weight(1f)
					.fillMaxHeight(),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(text = "Privacy Policy", modifier = Modifier.padding(10.dp))
				Spacer(
					modifier = Modifier
						.width(5.dp)
						.height(5.dp)
						.clip(CircleShape)
						.background(MaterialTheme.colorScheme.onBackground.copy(.8f))

				)
				Text(text = "Terms & Conditions", modifier = Modifier.padding(10.dp))
			}

		}
	}
}


@Composable
fun TextGroup(label: String, value: String) {
	Column(
		modifier = Modifier.padding(20.dp, 8.dp)
	) {
		Text(
			text = "$label: ",
			modifier = Modifier.padding(0.dp, 5.dp),
			style = TextStyle(
				fontSize = 16.sp,

				color = MaterialTheme.colorScheme.secondary
			)
		)
		Text(
			text = value,
			style = TextStyle(
				fontSize = 18.sp,
				fontWeight = FontWeight.SemiBold,
				color = MaterialTheme.colorScheme.primary
			),
			modifier = Modifier
				.fillMaxWidth()
				.padding(0.dp, 0.dp, 0.dp, 8.dp)
		)
		Spacer(
			modifier = Modifier
				.fillMaxWidth()
				.height(.5.dp)
				.background(MaterialTheme.colorScheme.primary)
		)
	}
}