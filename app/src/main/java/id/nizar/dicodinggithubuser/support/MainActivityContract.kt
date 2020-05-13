package id.nizar.dicodinggithubuser.support

import id.nizar.dicodinggithubuser.models.GithubRepo
import id.nizar.dicodinggithubuser.ui.base.BasePresenter
import id.nizar.dicodinggithubuser.ui.base.BaseView


interface MainActivityContract {

    interface View : BaseView {

        fun updateData(repo: List<GithubRepo>)

        fun showMessage(msg: String)
    }

    interface Presenter : BasePresenter {

        fun gitHubUser(userName: String)

        fun loadData()
    }
}