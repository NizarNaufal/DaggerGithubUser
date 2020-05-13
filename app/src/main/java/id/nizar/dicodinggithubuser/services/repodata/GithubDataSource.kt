package id.nizar.dicodinggithubuser.services.repodata

import id.nizar.dicodinggithubuser.models.GithubRepo
import io.reactivex.Observable

interface GithubDataSource {
    fun getRepos(userName: String): Observable<List<GithubRepo>>
}