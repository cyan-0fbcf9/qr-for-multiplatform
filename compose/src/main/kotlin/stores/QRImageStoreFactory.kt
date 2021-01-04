package stores

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import stores.QRImageStore.Intent
import stores.QRImageStore.State
import java.awt.image.BufferedImage

internal class QRImageStoreFactory(private val storeFactory: StoreFactory) {

    private sealed class Result {
        class QRImage(val image: BufferedImage) : Result()
    }


    fun create(): QRImageStore =
        object : QRImageStore,
            Store<Intent, State, Nothing> by storeFactory.create(
                name = "QRImageStore",
                initialState = State(),
                executorFactory = ::ExecuteImpl,
                reducer = ReducerImpl,
            ) {}

    private class ExecuteImpl :
        SuspendExecutor<Intent, Nothing, State, Result, Nothing>() {
        override suspend fun executeIntent(
            intent: Intent,
            getState: () -> State
        ) {
            when (intent) {
                is Intent.SetQRImage -> dispatch(Result.QRImage(intent.image))
            }
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.QRImage -> copy(qrImage = result.image)
            }
    }
}
