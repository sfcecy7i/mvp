package com.cmos.framework.mvp.kt

import android.app.Activity

inline fun <reified V : KView<P, V>, reified P : KPresenter<P, V>> V.bind(presenter: P): V {
    this.presenter = presenter
    presenter.ui = this
    this.init()
    this.presenter!!.init()
    return this
}

inline fun <reified V : KView<P, V>, reified P : KPresenter<P, V>> P.bind(ui: V): P {
    this.ui = ui
    ui.presenter = this
    this.init()
    this.ui!!.init()
    return this
}

inline fun <reified V : KView<P, V>, reified P : KPresenter<P, V>> V.unbind() {
    this.presenter?.let {
        it.destroy()
        it.ui = null
    }
    this.presenter = null
    this.destroy()
}

inline fun <reified V : KView<P, V>, reified P : KPresenter<P, V>> P.unbind() {
    this.ui?.let {
        it.destroy()
        it.presenter = null
    }
    this.ui = null
    this.destroy()
}

interface KView<P : KPresenter<P, V>, V : KView<P, V>> {
    var presenter: P?

    fun init() {}

    fun destroy() {}
}

interface KPresenter<P : KPresenter<P, V>, V : KView<P, V>> {
    var ui: V?

    fun init() {}

    fun destroy() {}
}

abstract class KBaseView<P : KPresenter<P, V>, V : KView<P, V>, out A : Activity>(activity: A) : KView<P, V> {
    override var presenter: P? = null

}

abstract class KBasePresenter<P : KPresenter<P, V>, V : KView<P, V>> : KPresenter<P, V> {
    override var ui: V? = null
}