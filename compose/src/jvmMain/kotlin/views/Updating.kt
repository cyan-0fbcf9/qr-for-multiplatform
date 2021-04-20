@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import app.AppResource
import app.AppService
import app.AppWindows
import components.theme.AppTheme
import components.theme.FONT_COLOR
import functions.getVersion
import static.url.SITE
import java.awt.Desktop
import java.lang.Exception
import java.net.URI

fun Updating() = Window(
    title = AppWindows.DefinedWindow.UPDATING,
    size = IntSize(400, 450),
    icon = AppResource.AppIcon,
    resizable = false,
) {
    val indicatorVisibilityState: MutableState<Boolean> = remember { mutableStateOf(false) }
    val existLatestVersion: MutableState<Boolean?> = remember { mutableStateOf(null) }

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
            Text("現在のバージョン：${getVersion() ?: "DEVELOPMENT"}")
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
                    existLatestVersion.value = try {
                        AppService.httpService.apiRequests.checkUpdate(getVersion() ?: "")
                    } catch (e: Exception) {
                        // TODO("Log")
                        false
                    } finally {
                        indicatorVisibilityState.value = false
                    }
                }
            ) {
                Text("アップデート確認")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(0.dp, 16.dp)
            ) {
                existLatestVersion.value?.let { value ->
                    if (value) {
                        Text("アップデートがあります")
                        IconButton(
                            onClick = {
                                Desktop.getDesktop().browse(URI(SITE.APPLICATION))
                            },
                        ) {
                            Icon(
                                imageResource("assets/file_download.png"),
                                "ダウンロード",
                                tint = FONT_COLOR,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    } else {
                        Text("アップデートはありません", color = Color.Gray)
                    }
                }
            }
        }
    }
}