package id.web.hn.basekotlinmvp.feature.base.adapter

import android.view.View

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

interface BaseRecyclerItemClickListener

interface OnRecyclerItemClickListener<D> : BaseRecyclerItemClickListener {

    fun onItemClicked(item:D, position:Int,view: View)
}
