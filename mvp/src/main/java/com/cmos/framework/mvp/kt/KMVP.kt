package com.cmos.framework.mvp.kt

import android.app.Activity

inline fun <reified V : KBaseView<P, Activity>, reified P : KBasePresenter<V>> V.bind(presenter: P) {
    this.presenter = presenter
    presenter.ui = this
}

inline fun <reified V : KBaseView<P, Activity>, reified P : KBasePresenter<V>> P.bind(ui: V) {
    this.ui = ui
    ui.presenter = this
}

interface KView

interface KPresenter {
    fun register()

    fun unregister()
}

abstract class KBasePresenter<V : KView> : KPresenter {
    var ui: V? = null

}

abstract class KBaseView<P : KPresenter, in A : Activity>(activity: A) : KView {
    var presenter: P? = null
}