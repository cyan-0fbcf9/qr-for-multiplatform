@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import app.AppResource
import app.AppWindows
import components.theme.AppTheme

fun Updating() = Window(
    title = AppWindows.DefinedWindow.UPDATING,
    size = IntSize(400, 400),
    icon = AppResource.AppIcon,
    resizable = false,
) {
    val indicatorVisibilityState: MutableState<Boolean> = remember { mutableStateOf(false) }

    AppTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(30.dp).fillMaxSize(),
        ) {
            Image(
                bitmap = imageResource("images/icon.png"),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text("現在のバージョン：${TODO() ?: "DEVELOPMENT"}")
            if (indicatorVisibilityState.value) {
                CircularProgressIndicator(
                    Modifier.padding(0.dp, 20.dp).size(40.dp)
                )
            } else {
                Spacer(Modifier.size(80.dp))
            }
            Button(
                onClick = {
                    indicatorVisibilityState.value = true
                }
            ) {
                Text("アップデート確認")
            }
        }
    }
}