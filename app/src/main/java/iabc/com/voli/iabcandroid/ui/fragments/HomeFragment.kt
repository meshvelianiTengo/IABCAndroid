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
import iabc.com.voli.iabcandroid.view.HomeFragmentView


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
    }

    override fun onDescriptionReceived(list: List<HomeFragmentSliderModel>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDescriptionError(msg: String) {
        makeToast(msg)
    }

    override fun onMoviesResponse(list: List<HomeFragmentMovieModel>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMoviesError(msg: String) {
        makeToast(msg)
    }
}