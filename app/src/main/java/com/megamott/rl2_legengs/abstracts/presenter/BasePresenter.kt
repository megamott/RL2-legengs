package com.megamott.rl2_legengs.abstracts.presenter

import com.megamott.rl2_legengs.abstracts.view.BaseView

open class BasePresenter<V: BaseView> : BaseMvpPresenter<V> {
    protected var view: V? = null
        private set

    override var isAttached: Boolean = view != null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

}