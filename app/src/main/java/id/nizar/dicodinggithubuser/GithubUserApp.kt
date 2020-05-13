package id.nizar.dicodinggithubuser

import android.app.Activity
import android.app.Application

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import id.nizar.dicodinggithubuser.dagger.DaggerAppComponent

class GithubUserApp : Application(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector() = activityInjector

}
