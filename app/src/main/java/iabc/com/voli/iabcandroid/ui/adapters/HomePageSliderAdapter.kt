package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel

/**
 * Created by tengo on 12/14/16.
 */
class HomePageSliderAdapter(private val context: Context, private val models: List<HomeFragmentSliderModel>) : PagerAdapter() {
    private val inflater : LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = models[position]
        val layout = inflater.inflate(R.layout.adapter_item_home_page_slider, container, false) as ViewGroup
        val text = layout.findViewById(R.id.adapter_home_fr_slider_text) as TextView
        text.text = item.text
        container.addView(layout)
        return layout
    }


    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


}