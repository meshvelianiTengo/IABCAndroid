package iabc.com.voli.iabcandroid

import android.app.Activity
import android.graphics.Bitmap
import android.support.annotation.AnimRes
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by tengo on 12/14/16.
 */

fun Fragment.makeToast(msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.makeToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImageFromUrl(url: String?, placeHolder: Int? = null){
    if(url != null) {
        if(placeHolder != null) {
            Glide.with(context).load(url).placeholder(placeHolder).into(this)
        }else{
            Glide.with(context).load(url).into(this)
        }
    }else{
        if(placeHolder != null){
            setImageResource(placeHolder)
        }
    }
}

fun ImageView.loadImageFromUrlWithFitCenter(url: String?, placeHolder: Int? = null){
    if(url != null) {
        if(placeHolder != null) {
            Glide.with(context).load(url).placeholder(placeHolder).fitCenter().into(this)
        }else{
            Glide.with(context).load(url).into(this)
        }
    }else{
        if(placeHolder != null){
            setImageResource(placeHolder)
        }
    }
}


fun ImageView.loadRoundImageFromUrl(url: String, placeHolder: Int? = null){
    if(url != null) {
        Glide.with(context).load(url).asBitmap().into(object : BitmapImageViewTarget(this) {
            override fun setResource(resource: Bitmap) {
                val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, resource)
                circularBitmapDrawable.isCircular = true
                setImageDrawable(circularBitmapDrawable)
            }
        })
    }else{
        if(placeHolder != nextFocusUpId) {
            setImageResource(placeHolder as Int)
        }
    }
}

fun TextView.setTextOrGone(value: String?){
    if(value != null){
        text = value
    }else{
        visibility = GONE
    }
}

fun AppCompatActivity.changeFragment(@IdRes frView: Int, fragment: Fragment, @AnimRes enterAnim: Int = R.anim.fade_in, @AnimRes exitAnim: Int = R.anim.fade_out){
    supportFragmentManager.beginTransaction().replace(frView, fragment, fragment.javaClass.simpleName).setCustomAnimations(enterAnim, exitAnim).commit()
}

inline fun View.afterMeasured(crossinline f: View.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredHeight > 0 && measuredWidth > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}
