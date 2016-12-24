package iabc.com.voli.iabcandroid

import android.app.Activity
import android.graphics.Bitmap
import android.support.v4.app.Fragment
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by tengo on 12/14/16.
 */

fun Fragment.makeToast(msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT)
}

fun Activity.makeToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT)
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


fun ImageView.setRoundImageFromUrl(url: String, placeHolder: Int? = null){
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