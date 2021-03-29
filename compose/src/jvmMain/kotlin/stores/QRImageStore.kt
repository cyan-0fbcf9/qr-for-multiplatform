package stores

import com.arkivanov.mvikotlin.core.store.Store
import stores.QRImageStore.Intent
import stores.QRImageStore.State
import java.awt.image.BufferedImage

internal interface QRImageStore : Store<Intent, State, Nothing> {
    sealed class Intent {
        data class SetQRImage(val image: BufferedImage) : Intent()
    }

    data class State(
        val qrImage: BufferedImage? = null
    )
}