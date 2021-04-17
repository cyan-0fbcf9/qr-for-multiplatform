@file:Suppress("FunctionName")

package components.usage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.theme.FONT_COLOR

@Composable
fun UsageTitle(text: String) {
    Text(
        text,
        style = TextStyle(
            color = MaterialTheme.colors.primary,
            fontSize = 36.sp,
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun UsageHeading1(text: String) {
    Text(
        text,
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        style = TextStyle(
            color = FONT_COLOR,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold

        )
    )
}

@Composable
fun UsageHeading2(text: String) {
    Text(
        text,
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        style = TextStyle(
            color = FONT_COLOR,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun UsageBody(text: String) {
    Text(
        text,
        style = TextStyle(
            color = FONT_COLOR,
            fontSize = 16.sp,
        ),
        color = Color.DarkGray
    )
}

@Composable
fun UsageSubBody(text: String) {
    Text(
        text,
        style = TextStyle(
            color = FONT_COLOR,
            fontSize = 14.sp,
        ),
        color = Color.Gray
    )
}