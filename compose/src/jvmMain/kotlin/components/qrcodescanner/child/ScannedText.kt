@file:Suppress("FunctionName")

package components.qrcodescanner.child

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ScannedText(value: String) {
    // TODO: URL形式ならハイパーリンクにしたい
    Text(value)
}