package id.example.mvp.feature.base

import com.derohimat.sweetalertdialog.SweetAlertDialog
import id.example.mvp.core.ext.DialogFactory
import id.example.mvp.core.ext.toast

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

abstract class BaseMvpActivity : BaseActivity(), MvpView {

    private var progressDialog: SweetAlertDialog? = null

    protected abstract fun attachView()

    protected abstract fun detachView()

    override fun onPause() {
        super.onPause()
        showProgress(false)
    }

    override fun onStop() {
        super.onStop()
        showProgress(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        detachView()
        if (progressDialog != null) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    override fun showProgress(show: Boolean) {
        if (!isFinishing) {
            if (show) {
                progressDialog = DialogFactory.createProgressDialog(context)
                if (progressDialog != null) progressDialog?.show()
            } else {
                if (progressDialog != null) progressDialog?.dismissWithAnimation()
            }
        }
    }

    override fun showError(error: Throwable) {
        if (!isFinishing) {
            error.message?.let { DialogFactory.createErrorDialog(context, it).show() }
        }
    }

    override fun showNoData() {
    }

    override fun showToast(message: String) {
        toast(message)
    }
}
