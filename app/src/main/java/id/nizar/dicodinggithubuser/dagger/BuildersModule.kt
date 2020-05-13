package id.nizar.dicodinggithubuser.dagger


import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.nizar.dicodinggithubuser.support.MainModule
import id.nizar.dicodinggithubuser.ui.act.MainActivity


@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun bindMainActivity(): MainActivity
}