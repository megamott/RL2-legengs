package com.megamott.rl2_legengs.abstracts.presenter

import com.megamott.rl2_legengs.abstracts.view.BaseView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BasePresenterTest {

    @Mock
    private lateinit var baseView : BaseView
    @Mock
    private lateinit var baseMvpPresenter: BaseMvpPresenter<BaseView>

    private lateinit var basePresenter: BasePresenter<BaseView>

    @Before
    fun setUp() {
        basePresenter = BasePresenter()
    }

    @Test
    fun getView() {
    }

    @Test
    fun isAttached() {
        basePresenter.attach(baseView)
    }

    @Test
    fun setAttached() {
    }

    @Test
    fun attach() {
    }

    @Test
    fun detach() {
    }
}