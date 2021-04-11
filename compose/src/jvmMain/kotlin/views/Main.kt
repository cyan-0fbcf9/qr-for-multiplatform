@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import components.qrCodeFacility.QRCodeFacility
import components.qrCodeScanner.QRCodeScanner
import modules.singleton.AppResource
import static.APP_NAME

fun Main() = Window(
    title = APP_NAME,
    size = IntSize(1200, 700),
    icon = AppResource.AppIcon
) {
    MaterialTheme {
        val tabIndex: MutableState<Int> = remember { mutableStateOf(0) }

        Column(
            verticalArrangement = Arrangement.Top,
        ) {
            TabRow(
                selectedTabIndex = tabIndex.value,
            ) {
                Tab(true, onClick = {
                    tabIndex.value = 0
                }) {
                    Text("生成", modifier = Modifier.padding(vertical = 10.dp))
                }
                Tab(true, onClick = {
                    tabIndex.value = 1
                }) {
                    Text("読取", modifier = Modifier.padding(vertical = 10.dp))
                }
            }
            when (tabIndex.value) {
                0 -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        QRCodeFacility("https://google.com")
                    }
                }
                1 -> {
                    QRCodeScanner()
                }
            }
        }
    }
}