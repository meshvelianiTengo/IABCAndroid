package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.FAQModel

/**
 * Created by tengo on 12/25/16.
 */
class FAQAdapter(private val list: List<FAQModel>, private val context: Context) : BaseAdapter() {

    val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getItem(p0: Int): FAQModel {
        return list[p0]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemId(p0: Int): Long {
        return -1;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v : View
        if(convertView == null){
            v = inflater.inflate(R.layout.fr_faq_list_element, null)
            val holder = ItemHolder(v)
            v.tag = holder
        }else{
            v = convertView
        }

        val holder = v.tag as ItemHolder
        holder.fillViews(getItem(position))

        return v
    }


    inner class ItemHolder(private val view: View){
        var questionTV: TextView
        var answearTV: TextView

        init {
            questionTV = view.findViewById(R.id.fr_faq_list_element_question) as TextView
            answearTV = view.findViewById(R.id.fr_faq_list_element_answear) as TextView
        }

        fun fillViews(model: FAQModel){
            questionTV.text = model.question
            answearTV.text = model.answear
        }
    }
}