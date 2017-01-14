package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.afterMeasured
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel
import iabc.com.voli.iabcandroid.presenter.HomeFragmentPresenter
import iabc.com.voli.iabcandroid.ui.adapters.HomePageAdapter
import iabc.com.voli.iabcandroid.ui.adapters.HomePageSliderAdapter
import iabc.com.voli.iabcandroid.view.HomeFragmentView
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by tengo on 12/13/16.
 */
class HomeFragment : BaseFragment(), HomeFragmentView {

    companion object {
        var viewPagerWidth = 0
        var movieCount = 5
    }

    val presenter: HomeFragmentPresenter

    init {
        presenter = HomeFragmentPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingDesctiption()
        presenter.startGettingMovies()

        home_fr_more.setOnClickListener { onMoreClicked() }
    }

    //ovveriding home fragment view functions : start
    override fun onDescriptionReceived(list: List<HomeFragmentSliderModel>) {
        home_fr_top_pager.adapter = HomePageSliderAdapter(context, list)
        home_fr_tablayout.setupWithViewPager(home_fr_top_pager, true)
    }

    override fun onDescriptionError(msg: String) {
        makeToast(msg)
    }

    override fun onMoviesResponse(list: List<HomeFragmentMovieModel>) {
        movieCount = list.size
        val adapter = HomePageAdapter(context, list)
//        home_fr_movie_pager.pageMargin = 30
        home_fr_movie_pager.afterMeasured {
            val width = home_fr_movie_pager.width
            if (width > 0) {
                val padding = width * 3 / 8
                home_fr_movie_pager.setPadding(padding, 0, padding, 0)
                viewPagerWidth = width
            }
        }

//        home_fr_top_pager.offscreenPageLimit = 3* movieCount
        home_fr_movie_pager.adapter = adapter
        home_fr_movie_pager.setPageTransformer(false, adapter);
        home_fr_movie_pager.setCurrentItem(10000, true)
        home_fr_movie_pager.scrollTo(home_fr_movie_pager.scrollX, 0)
//        val adapter = ControlFlowAdapter(context, list)
//        home_page_control_flow.adapter = adapter
//        home_fr_movie_pager.setPageTransformer(true, adapter)

    }

    override fun onMoviesError(msg: String) {
        makeToast(msg)
    }
    //ovveriding home fragment view functions : end

    //override func end

    fun onMoreClicked() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}