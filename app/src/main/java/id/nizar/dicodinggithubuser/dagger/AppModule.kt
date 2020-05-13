package id.nizar.dicodinggithubuser.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.nizar.dicodinggithubuser.services.api.ApiClient
import id.nizar.dicodinggithubuser.services.api.ApiServices
import id.nizar.dicodinggithubuser.services.repodata.GithubData
import id.nizar.dicodinggithubuser.services.repodata.GithubDataSource
import id.nizar.dicodinggithubuser.support.NetworkingState
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideNetworkUtil(context: Context) : NetworkingState = NetworkingState(context)

    @Singleton
    @Provides
    fun provideApiService(): ApiServices = ApiClient.getGitHubService()

    @Singleton
    @Provides
    fun provideGithubDataSourse(mService: ApiServices): GithubDataSource = GithubData(mService)

}