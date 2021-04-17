@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import app.AppResource
import app.AppWindows
import components.theme.AppTheme
import static.APP_NAME
import static.USAGE_DESCRIPTION
import static.USAGE_SUBTITLE

fun Usage() = Window(
    title = AppWindows.DefinedWindow.USAGE,
    size = IntSize(480, 550),
    icon = AppResource.AppIcon,
    resizable = false,
) {
    AppTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(MaterialTheme.colors.background).fillMaxSize().padding(horizontal = 30.dp)
        ) {
            Image(
                bitmap = imageResource("images/icon.png"),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
            Text(APP_NAME, style = MaterialTheme.typography.h4)
            Text(
                USAGE_SUBTITLE,
                modifier = Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.subtitle1
            )
            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text(
                    "使い方",
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    style = MaterialTheme.typography.h6,
                    color = Color.DarkGray
                )
                Text(
                    USAGE_DESCRIPTION,
                    style = MaterialTheme.typography.body1,
                    color = Color.DarkGray
                )
            }
        }
    }
}