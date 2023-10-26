package com.marcsedev.testingui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiComponent() {
    var name by rememberSaveable {
        mutableStateOf("TEST")
    }

    Column(Modifier.fillMaxSize()) {
        TextField(value = name, onValueChange = {name = it}, modifier = Modifier.testTag("textFieldName"))
        Text(text = "Your name is $name", modifier = Modifier.testTag("textGreeting"))
        Text("Ada Lovelace", Modifier.testTag("component1"))
        Text("Hedy Lamarr", Modifier.testTag("component2"))

        Image(Icons.Rounded.AccountCircle, contentDescription = "profileImage")

    }
}