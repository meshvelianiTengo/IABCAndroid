package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.ui.custom.MyLinearLayout

/**
 * Created by tengo on 12/13/16.
 */
class HomePageAdapter (private val context: Context, private val models: List<HomeFragmentMovieModel>) : PagerAdapter(), ViewPager.PageTransformer {

    companion object {
        const val BIG_SCALE = 1.0f
        const val SMALL_SCALE = 0.7f
        const val DIFF_SCALE = BIG_SCALE - SMALL_SCALE
    }

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = inflater.inflate(R.layout.adapter_item_home_page, container, false) as ViewGroup
        container.addView(layout)
        return layout

    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

    override fun getPageWidth(position: Int): Float {
        return 0.3f
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return 30
    }

    override fun transformPage(page: View, position: Float) {
        val view = page.findViewById(R.id.adapter_item_home_page_root) as MyLinearLayout
        var scale = BIG_SCALE
        if (position > 0) {
            scale -= position * DIFF_SCALE
        } else {
            scale += position * DIFF_SCALE
        }
        if (scale < 0) scale = 0f

        view.setScaleBoth(scale)
    }
}