package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrl
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.ui.fragments.HomeFragment

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
        val image = layout.findViewById(R.id.home_fr_moview_adapter_image) as ImageView
        val text = layout.findViewById(R.id.home_fr_moview_adapter_text) as TextView
        image.loadImageFromUrl(models[position%HomeFragment.movieCount].image)
        text.text = models[position%HomeFragment.movieCount].title
        container.addView(layout)
        return layout

    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

//    override fun getPageWidth(position: Int): Float {
//        return 0.6f
//    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    var viewPager : ViewPager? = null

    override fun transformPage(view: View, position: Float) {
        if (viewPager == null) {
            viewPager = view.parent as ViewPager
        }

        if(viewPager != null) {
            val leftInScreen = view.left - viewPager!!.scrollX
            val centerXInViewPager = leftInScreen + view.measuredWidth / 2

            val offsetX = centerXInViewPager - viewPager!!.measuredWidth / 2
            val offsetRate = offsetX.toFloat() * 0.38f / viewPager!!.measuredWidth
            val scaleFactor = 1 - Math.abs(offsetRate)
            if (scaleFactor > 0) {
                view.scaleX = scaleFactor
                view.scaleY = scaleFactor
//                view.translationX = -100 * offsetRate
            }else{
//                view.scaleX = SMALL_SCALE
//                view.scaleY = SMALL_SCALE
            }

//            val offsetX = viewPager!!.measuredWidth / 2 - centerXInViewPager
//            val offsetRate = offsetX.toFloat() / view.measuredWidth
//            var scaleFactor = SMALL_SCALE + DIFF_SCALE/2 + DIFF_SCALE * Math.abs(offsetRate)
////            scaleFactor = Math.max(scaleFactor, SMALL_SCALE)
////            scaleFactor = Math.min(scaleFactor, BIG_SCALE)
//
////            container.setScaleBoth(scaleFactor);
//            if(scaleFactor >= SMALL_SCALE && scaleFactor <= BIG_SCALE){
//                view.scaleX = scaleFactor
//                view.scaleY = scaleFactor
//            }
            print("offset")
            print("offsetRate = " + offsetRate.toString() + " // scaleF = " + scaleFactor.toString())

        }
    }
}