package com.megamott.rl2_legengs.abstracts.presenter

import android.content.Context
import android.view.View
import com.megamott.rl2_legengs.abstracts.view.BaseView

interface BaseMvpPresenter<V: BaseView> {
    var isAttached: Boolean
    fun attach(view: V)
    fun detach()
}