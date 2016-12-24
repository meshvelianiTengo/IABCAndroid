package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrl
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel

/**
 * Created by tengo on 12/16/16.
 */
class ControlFlowAdapter(private val context: Context, private val models: List<HomeFragmentMovieModel>) : BaseAdapter(){

    val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v: View

        if(convertView == null){
            v = inflater.inflate(R.layout.adapter_item_home_page, null)
            val locHolder = ViewHolder()
            locHolder.initFromView(v)
            v.tag = locHolder
        }else{
            v = convertView
        }

        val holder = v.tag as ViewHolder
        holder.fillViews(getItem(position))
        return v
    }

    override fun getItem(p0: Int): HomeFragmentMovieModel {
        return models[p0]
    }

    override fun getItemId(p0: Int): Long {
        return -1.toLong()
    }

    override fun getCount(): Int {
        return models.count()
    }

    inner class ViewHolder{
        lateinit var imageView: ImageView
        lateinit var textView: TextView

        fun initFromView(parent: View){
            imageView = parent.findViewById(R.id.home_fr_moview_adapter_image) as ImageView
            textView = parent.findViewById(R.id.home_fr_moview_adapter_text) as TextView
        }

        fun fillViews(item: HomeFragmentMovieModel){
            imageView.loadImageFromUrl(item.image, R.mipmap.into_image)
            textView.text = item.title
        }
    }
}