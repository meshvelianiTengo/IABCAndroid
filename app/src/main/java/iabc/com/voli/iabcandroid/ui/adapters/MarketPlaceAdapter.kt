package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrlWithFitCenter
import iabc.com.voli.iabcandroid.models.MovieItemModel
import iabc.com.voli.iabcandroid.ui.custom.MovieListItem

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceAdapter(private val context: Context, private val list: List<MovieItemModel>) : BaseAdapter(){
    val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v : View
        if(convertView == null){
            v = inflater.inflate(R.layout.fr_market_place_list_item, null)
            val holder = ItemHolder()
            holder.initViews(v)
            v.tag = holder
        }else{
            v = convertView
        }

        val holder = v.tag as ItemHolder

        val item1 = list[position *3]
        val innerPos1 = position * 3 + 1
        val innerPos2 = position * 3 + 2

        val item2 = if(list.size > innerPos1) list[innerPos1] else null
        val item3 = if(list.size > innerPos2) list[innerPos2] else null

        holder.fillViews(item1, item2, item3)

        return v
    }

    override fun getItem(p0: Int): Any {
        return list[p0/3]
    }

    override fun getItemId(p0: Int): Long {
        return -1;
    }

    override fun getCount(): Int {
        return (list.size + 2) / 3;
    }

    inner class ItemHolder{
        lateinit var view1: MovieListItem
        lateinit var view2: MovieListItem
        lateinit var view3: MovieListItem

        fun initViews(parent: View){
            view1 = parent.findViewById(R.id.fr_market_place_list_item_1) as MovieListItem
            view2 = parent.findViewById(R.id.fr_market_place_list_item_2) as MovieListItem
            view3 = parent.findViewById(R.id.fr_market_place_list_item_3) as MovieListItem
        }

        fun fillViews(item1: MovieItemModel, item2: MovieItemModel?, item3: MovieItemModel?){
            fillView(item1, view1)
            fillView(item2, view2)
            fillView(item3, view3)

        }

        private fun fillView(item: MovieItemModel?, view: MovieListItem){
            if(item != null){
                view.visibility = View.VISIBLE
                view.image.loadImageFromUrlWithFitCenter(item.imageUrl, R.drawable.home_fragment_gradient_background_color)
                view.setName(item.name)
                view.setType(item.type)
            }else{
                view.visibility = View.INVISIBLE
            }
        }

    }
}