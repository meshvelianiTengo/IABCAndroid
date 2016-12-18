package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import iabc.com.voli.iabcandroid.R

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsPagerAdapter(private val context: Context, private val list: List<String>) : PagerAdapter() {
    private val inflater: LayoutInflater
    init {
        inflater = LayoutInflater.from(context)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = inflater.inflate(R.layout.about_us_pager_item, container, false) as ViewGroup
        val text = layout.findViewById(R.id.about_us_pager_item_text) as TextView
        text.text = list[position]
        container.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

}