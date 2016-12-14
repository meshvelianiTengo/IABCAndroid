package iabc.com.voli.iabcandroid

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by tengo on 12/14/16.
 */

fun Fragment.makeToast(msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT)
}