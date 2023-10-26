package com.marcsedev.testingui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun TestUiComponent() {
    Column(Modifier.fillMaxSize()) {
        Text("Ada Lovelace", Modifier.testTag("component1"))
        Text("Hedy Lamarr", Modifier.testTag("component2"))

        Image(Icons.Rounded.AccountCircle, contentDescription = "profileImage")

    }
}