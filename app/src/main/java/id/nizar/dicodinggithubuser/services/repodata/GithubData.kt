package id.nizar.dicodinggithubuser.services.repodata

import id.nizar.dicodinggithubuser.models.GithubRepo
import id.nizar.dicodinggithubuser.services.api.ApiServices
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubData @Inject
constructor(private val mService: ApiServices) : GithubDataSource {

    override fun getRepos(userName: String): Observable<List<GithubRepo>> {
        return mService.getRepositories(userName)
    }
}