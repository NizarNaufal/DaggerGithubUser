package id.nizar.dicodinggithubuser.services.api

import id.nizar.dicodinggithubuser.models.GithubRepo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") userName: String): Observable<List<GithubRepo>>

}