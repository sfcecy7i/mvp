package com.cmos.framework.mvp.kt

import android.app.Activity

inline fun <reified A : Activity, reified V : KBaseView<P, A>, reified P : KBasePresenter<V>> V.bind(presenter: P) {
    this.presenter = presenter
    presenter.ui = this
    this.init()
    this.presenter!!.init()
}

inline fun <reified A : Activity, reified V : KBaseView<P, A>, reified P : KBasePresenter<V>> P.bind(ui: V) {
    this.ui = ui
    ui.presenter = this
    this.init()
    this.ui!!.init()
}

inline fun <reified A : Activity, reified V : KBaseView<P, A>, reified P : KBasePresenter<V>> V.unbind() {
    this.presenter?.let {
        it.destroy()
        it.ui = null
    }
    this.presenter = null
    this.destroy()
}

inline fun <reified A : Activity, reified V : KBaseView<P, A>, reified P : KBasePresenter<V>> P.unbind() {
    this.ui?.let {
        it.destroy()
        it.presenter = null
    }
    this.ui = null
    this.destroy()
}

interface KView {
    fun init()

    fun destroy()
}

interface KPresenter {
    fun init()

    fun destroy()
}

abstract class KBasePresenter<V : KView> : KPresenter {
    var ui: V? = null

    override fun init() {}

    override fun destroy() {}
}

abstract class KBaseView<P : KPresenter, in A : Activity>(activity: A) : KView {
    var presenter: P? = null

    override fun init() {}

    override fun destroy() {}
}