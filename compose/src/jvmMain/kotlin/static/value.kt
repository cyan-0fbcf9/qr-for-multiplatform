package static

import osJunction

val USAGE_DESCRIPTION: String =
    """
        QRコードをスクリーンショットするだけでOK。
        読み取ったQRコードはデフォルトブラウザで開かれます。
    """.trimIndent()

val USAGE_SUBTITLE: String =
    """
        ディスプレイに表示されているQRコードを読み取れるQRスキャナ
    """.trimIndent()

val SHORTCUT_DESCRIPTION = osJunction(
    onWindows = {
        "ウィンドウズキー + Shift + S"
    },
    onMac = {
        "Command + Shift + Control + 4"
    }
)