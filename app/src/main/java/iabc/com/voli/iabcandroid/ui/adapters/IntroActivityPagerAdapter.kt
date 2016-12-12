package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.IntroActivityModel

/**
 * Created by tengo on 12/12/16.
 */

class IntroActivityPagerAdapter(private val mContext: Context, private val models: List<IntroActivityModel>) : PagerAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(mContext)
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val item = models[position]
        val layout = inflater.inflate(R.layout.intro_act_pager_item, collection, false) as ViewGroup
        val title = layout.findViewById(R.id.intro_act_pager_item_title) as TextView
        val desc = layout.findViewById(R.id.intro_act_pager_item_desc) as TextView

        title.text = item.title
        desc.text = item.content
        collection.addView(layout)
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