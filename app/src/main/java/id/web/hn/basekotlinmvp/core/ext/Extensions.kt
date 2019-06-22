package id.web.hn.basekotlinmvp.core.ext

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import id.web.hn.svgloaderlib.SvgLoader

/**
 * Created by hahn on 21.06.19.
 * Project: BaseKotlinMvp
 */

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun ImageView.loadImageFromUrlCircle(url: String) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.loadImageFromBitmap(img: Bitmap) {
    Glide.with(context)
        .load(img)
        .into(this)
}

fun ImageView.loadImageFromSvg(url: String) {
    SvgLoader.pluck()
        .with(context as Activity?)
        .load(url, this)

}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

/**
 * Extension method use to display a [Snackbar] message to the user.
 */
fun View.displaySnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val snakbar = Snackbar.make(this, message, duration)
    snakbar.show()
    return snakbar
}

/**
 * Extension method use to display a [Snackbar] message to the user.
 */
fun View.displaySnackbar(messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val snakbar = Snackbar.make(this, messageResId, duration)
    snakbar.show()
    return snakbar
}
