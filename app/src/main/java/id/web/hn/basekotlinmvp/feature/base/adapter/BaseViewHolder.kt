package id.web.hn.basekotlinmvp.feature.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

abstract class BaseViewHolder<D,L : BaseRecyclerItemClickListener>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(item:D, listener:L?)
}
