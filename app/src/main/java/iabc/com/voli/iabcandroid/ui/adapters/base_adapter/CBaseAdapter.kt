package iabc.com.voli.iabcandroid.ui.adapters.base_adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by tengo on 12/26/16.
 */
abstract class CBaseAdapter(protected val context: Context) : BaseAdapter(){

    val inflater : LayoutInflater
    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v : View
        if(convertView == null){
            v = inflater.inflate(getLayoutResId(), null)
            val holder = getItemHolder(v)
            v.tag = holder
        }else{
            v = convertView
        }

        val holder = v.tag as CBaseItemHolder
        holder.fillViews(position)
        return v
    }

    override fun getItemId(p0: Int): Long {
        return -1;
    }

    abstract fun getItemHolder(v: View): CBaseItemHolder;

    abstract @LayoutRes fun getLayoutResId(): Int

    abstract class CBaseItemHolder(view: View){

        abstract fun fillViews(position: Int)
    }
}