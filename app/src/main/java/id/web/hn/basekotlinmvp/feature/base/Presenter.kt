package id.web.hn.basekotlinmvp.feature.base

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()
}
