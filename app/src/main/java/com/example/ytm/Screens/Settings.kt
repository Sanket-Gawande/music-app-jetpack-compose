package com.example.ytm.Screens

import android.os.Build
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen() {
	Column(
		modifier = Modifier
			.fillMaxHeight()
			.verticalScroll(ScrollState(1))
	) {
		Text(
			text = "Settings",
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp),
			style = TextStyle(
				textAlign = TextAlign.Center,
				fontSize = 20.sp,
				color = MaterialTheme.colorScheme.onBackground
			)
		)
	}
}
