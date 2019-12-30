package com.abrahamlay.base.subscriber

import io.reactivex.subscribers.DisposableSubscriber

abstract class DefaultSubscriber<T> : DisposableSubscriber<T>() {
    override fun onComplete() {
        // no-op by default.
    }

    override fun onNext(data: T) {
        onSuccess(data)
    }

    override fun onError(throwable: Throwable) {
        // no-op by default.
    }

    abstract fun onSuccess(data: T)
}