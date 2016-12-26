package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.CompanyListFrModel
import iabc.com.voli.iabcandroid.loadRoundImageFromUrl


/**
 * Created by tengo on 12/23/16.
 */
class CompanyListFrAdapter(private val context: Context, private val list: List<CompanyListFrModel>) : BaseAdapter() {
    val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v : View
        if(convertView == null){
            v = inflater.inflate(R.layout.fr_company_list_item, null)
            val holder = ItemHolder(v)
            v.tag = holder
        }else{
            v = convertView
        }

        val holder = v.tag as ItemHolder
        holder.fillViews(getItem(position))

        return v
    }

    override fun getItem(p0: Int): CompanyListFrModel {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return -1
    }


    inner class ItemHolder(private val view: View){
        val textV: TextView
        val imageV: ImageView

        init {
            textV = view.findViewById(R.id.fr_company_list_item_name) as TextView
            imageV = view.findViewById(R.id.fr_company_list_item_image) as ImageView
        }

        fun fillViews(item: CompanyListFrModel){
            textV.text = item.name
            imageV.loadRoundImageFromUrl(item.imageUrl)
        }
    }
}