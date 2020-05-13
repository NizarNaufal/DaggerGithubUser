package id.nizar.dicodinggithubuser.support

import dagger.Module
import dagger.Binds
import id.nizar.dicodinggithubuser.ui.act.MainActivity


@Module
abstract class MainModule {

    @Binds
    internal abstract fun mView(
            mainActivity: MainActivity
    ): MainActivityContract.View

    @Binds
    internal abstract fun mPresenter(
            presenterImplement: MainPresenterImplement
    ): MainActivityContract.Presenter

}