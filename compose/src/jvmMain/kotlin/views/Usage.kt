@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import app.AppResource
import app.AppWindows
import static.APP_NAME

fun Usage() = Window(
    title = AppWindows.DefinedWindow.USAGE,
    size = IntSize(400, 600),
    icon = AppResource.AppIcon,
    resizable = false,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            bitmap = imageResource("images/icon.png"),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Text(APP_NAME, style = MaterialTheme.typography.h3)
    }
}