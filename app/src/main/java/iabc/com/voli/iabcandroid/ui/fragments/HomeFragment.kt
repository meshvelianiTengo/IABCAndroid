package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.ui.adapters.HomePageAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


/**
 * Created by tengo on 12/13/16.
 */
class HomeFragment : BaseFragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomePageAdapter(context, ArrayList<HomeFragmentMovieModel>())
        pager.adapter = adapter
        pager.setPageTransformer(false, adapter);


    }

//    override fun onResume() {
//        super.onResume()
//        home_pager.viewTreeObserver.addOnGlobalLayoutListener{
//            val width = home_pager.width
////            home_pager.pageMargin = -1 * width/2;
////            print("21312312  " + width.toString())
//            home_pager.getChildAt(0).setPadding(width/2, 0, 0, 0)
//        }
//    }

}