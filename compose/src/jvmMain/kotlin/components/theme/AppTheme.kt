@file:Suppress("FunctionName")

package components.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) = MaterialTheme(
    colors = LIGHT_COLOR,
) {
    content()
}