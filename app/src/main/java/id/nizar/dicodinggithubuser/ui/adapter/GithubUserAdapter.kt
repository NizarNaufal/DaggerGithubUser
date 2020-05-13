package id.nizar.dicodinggithubuser.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.nizar.dicodinggithubuser.R
import id.nizar.dicodinggithubuser.models.GithubRepo
import kotlinx.android.synthetic.main.item_user_github.view.*

class GithubUserAdapter (private val mContext:Context) :RecyclerView.Adapter<GithubUserAdapter.GithubUserViewHolder>(){

    private val githubRepos = ArrayList<GithubRepo>()

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int): GithubUserViewHolder {
        val inflater = LayoutInflater.from(mContext)
        val view =inflater.inflate(R.layout.item_user_github,parent,false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder,postion:Int){
        holder.bindViews(githubRepos[postion])
    }

    fun setGithubRepos(repos:List<GithubRepo>?){
        if (repos == null){
            return
        }
        githubRepos.clear()
        githubRepos.addAll(repos)
        notifyDataSetChanged()
    }

    override fun getItemCount():Int{
        return githubRepos.size
    }

    inner class GithubUserViewHolder(itemview:View): RecyclerView.ViewHolder(itemview){
        fun bindViews(githubRepos: GithubRepo){
            itemView.text_repo_name.text = githubRepos.name
            itemView.text_repo_description.text = githubRepos.description
            itemView.text_language.text = String.format("Language: %s",githubRepos.language)
            itemView.text_stars.text = String.format("Stars: %s",githubRepos.stargazers_count)
        }
    }
}