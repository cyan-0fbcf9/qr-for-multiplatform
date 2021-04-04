@file:Suppress("FunctionName")

package components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ScannedText(value: String) {
    // TODO: URL形式ならハイパーリンクにしたい
    Text(value)
}