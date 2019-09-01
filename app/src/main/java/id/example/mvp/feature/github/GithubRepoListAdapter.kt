package id.example.mvp.feature.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.example.mvp.R
import id.example.mvp.core.data.model.Repos
import kotlinx.android.synthetic.main.item_repo_list.view.*

class GithubRepoListAdapter(val items: MutableList<Repos>, val listener: (Repos) -> Unit)
    : RecyclerView.Adapter<GithubRepoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Repos, listener: (Repos) -> Unit) = with(itemView) {
            txtName.text = item.name
            txtDescription.text = item.description

            setOnClickListener { listener(item) }
        }

    }
}