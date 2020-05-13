package id.nizar.dicodinggithubuser.ui.act

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.nizar.dicodinggithubuser.R
import id.nizar.dicodinggithubuser.models.GithubRepo
import id.nizar.dicodinggithubuser.support.MainActivityContract
import id.nizar.dicodinggithubuser.support.NetworkingState
import id.nizar.dicodinggithubuser.ui.adapter.GithubUserAdapter
import id.nizar.dicodinggithubuser.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContract.View {

    private val TAG:String = "MainActivity"
    private lateinit var recyclerAdapter: GithubUserAdapter

    @Inject
    lateinit var network: NetworkingState
    @Inject
    lateinit var githubPresenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        githubPresenter.subscribe()

        recyclerAdapter = GithubUserAdapter(this)
        rv_repos.layoutManager = LinearLayoutManager(this)
        rv_repos.adapter = recyclerAdapter

        btn_search.setOnClickListener{
            val username = edt_username.text.toString()
            if (!TextUtils.isEmpty(username)) {
                if (!network.isConnected()) {
                    hideKeyboard()
                    Snackbar.make(
                        parent_layout,
                        getString(R.string.no_internet),
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    githubPresenter.gitHubUser(username)
                    githubPresenter.loadData()
                    hideKeyboard()
                }
            }
        }
    }
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun updateData(repo: List<GithubRepo>) {
        recyclerAdapter.setGithubRepos(repo)
        Log.i(TAG, repo.toString())
    }

    override fun showMessage(msg: String) {
        Snackbar.make(parent_layout, msg, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        githubPresenter.unSubscribe()
    }
}