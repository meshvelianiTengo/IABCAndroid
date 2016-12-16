package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel
import iabc.com.voli.iabcandroid.presenter.HomeFragmentPresenter
import iabc.com.voli.iabcandroid.ui.adapters.ControlFlowAdapter
import iabc.com.voli.iabcandroid.ui.adapters.HomePageSliderAdapter
import iabc.com.voli.iabcandroid.view.HomeFragmentView
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by tengo on 12/13/16.
 */
class HomeFragment : BaseFragment(), HomeFragmentView{

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
        val adapter = ControlFlowAdapter(context, list)
        home_page_control_flow.adapter = adapter
//        home_fr_movie_pager.setPageTransformer(true, adapter)

    }

    override fun onMoviesError(msg: String) {
        makeToast(msg)
    }
    //ovveriding home fragment view functions : end

    //override func end

    fun onMoreClicked(){
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}