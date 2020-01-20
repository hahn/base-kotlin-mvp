package id.example.mvp.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.example.mvp.R
import id.example.mvp.core.data.model.GithubUser
import kotlinx.android.synthetic.main.item_user_list.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items: MutableList<GithubUser> = ArrayList()
    var listener: ((GithubUser) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_list, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GithubUser, listener: (GithubUser) -> Unit) = with(itemView) {
            txtName.text = item.login
            txtUrl.text = item.url

            setOnClickListener { listener(item) }
        }
    }
}
