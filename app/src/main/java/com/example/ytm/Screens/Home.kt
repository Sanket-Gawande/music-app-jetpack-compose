package com.example.ytm.Screens

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ytm.R
import com.example.ytm.categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
	var mediaPlayer = MediaPlayer()
	var audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.verticalScroll(ScrollState(1))
	) {

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp)
				.horizontalScroll(ScrollState(1)),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			for (cat in categories) {
				Button(
					shape = RoundedCornerShape(8.dp),
					colors = ButtonDefaults.buttonColors(
						containerColor = MaterialTheme.colorScheme.secondary,
						contentColor = MaterialTheme.colorScheme.onSecondary
					),
					onClick = { /*TODO*/ }) {
					Text(
						text = cat, style = TextStyle(
							color = MaterialTheme.colorScheme.onSecondary
						)
					)
				}
			}
		}

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(20.dp, 20.dp),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Image(
				modifier = Modifier
					.size(50.dp)
					.clip(CircleShape),
				painter = painterResource(id = R.drawable.fish), contentDescription = null
			)
			Column {
				Text(
					text = "Sanket Gawande", style = TextStyle(
						color = MaterialTheme.colorScheme.primary.copy(.8f),
						fontWeight = FontWeight.Light
					)
				)
				Text(
					text = "Listen Again",
					style = TextStyle(
						color = MaterialTheme.colorScheme.primary,
						fontWeight = FontWeight.Medium,
						fontSize = 24.sp
					)
				)
			}
		}

		LazyHorizontalGrid(
			modifier = Modifier
				.height(240.dp)
				.padding(10.dp, 0.dp, 0.dp, 20.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp),
			horizontalArrangement = Arrangement.spacedBy(10.dp),

			rows = GridCells.Adaptive(100.dp), content = {
				items(count = 12) { item ->
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.aspectRatio(1f),
						contentAlignment = Alignment.Center
					) {
						Image(
							painter = painterResource(id = R.drawable.fish),
							contentDescription = null,
							contentScale = ContentScale.Crop,
							modifier = Modifier.fillMaxWidth()
						)
						Box(
							modifier = Modifier
								.fillMaxSize()
								.background(Color.Black.copy(.3f))
								.blur(10.dp)
						)
						Text(
							text = "Song $item", style = TextStyle(
								fontSize = 20.sp,
								color = Color.White,
								fontWeight = FontWeight.SemiBold
							)
						)
					}
				}
			})

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(20.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Column {
				Text(
					text = "Start radio based on songs", style = TextStyle(
						color = MaterialTheme.colorScheme.primary.copy(.8f),
						fontWeight = FontWeight.Light
					)
				)
				Text(
					text = "Quick Picks",
					style = TextStyle(
						color = MaterialTheme.colorScheme.primary,
						fontWeight = FontWeight.Medium,
						fontSize = 24.sp
					)
				)
			}

			AssistChip(
				shape = CircleShape,
				onClick = { /*TODO*/ }, label = { Text(text = "Play All") })
		}

		Column(
			modifier = Modifier.padding(0.dp, 10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			for (i in 0..10) {
				Row(
					modifier = Modifier.padding(10.dp, 0.dp).fillMaxWidth().clickable {
					},
					horizontalArrangement = Arrangement.spacedBy(10.dp)
				) {
					Image(
						modifier = Modifier
							.size(60.dp)
							.aspectRatio(1f),
						painter = painterResource(id = R.drawable.fish), contentDescription = null
					)

					Column(
						modifier = Modifier
							.weight(1f)
							.fillMaxWidth()
					) {
						Text(
							text = "Some long text like extended song name",
							maxLines = 2,
							style = TextStyle(
								fontSize = 18.sp
							)
						)

						Text(
							text = "artists one, artist 2", maxLines = 2, style = TextStyle(
								fontSize = 16.sp,
								color = MaterialTheme.colorScheme.primary.copy(.5f)
							)
						)
					}

					IconButton(onClick = { /*TODO*/ }) {
						Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
					}
				}
			}
		}
	}

}