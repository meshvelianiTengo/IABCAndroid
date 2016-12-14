package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorDescriptionCallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorMoviesCallback
import iabc.com.voli.iabcandroid.interactors.HomeFragmentInteractor
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel
import iabc.com.voli.iabcandroid.view.HomeFragmentView

/**
 * Created by tengo on 12/14/16.
 */
class HomeFragmentPresenter(private val view: HomeFragmentView) : HomeFragmentInteractorDescriptionCallback, HomeFragmentInteractorMoviesCallback {
    val interactor: HomeFragmentInteractor
    init {
        interactor = HomeFragmentInteractor()
    }

    fun startGettingDesctiption(){
        interactor.startGettingHomeFragmentDescriptions(this)
    }

    fun startGettingMovies(){
        interactor.startGettingHomeFragmentRankedMovies(this)
    }

    override fun onDescriptionDownloaded(list: List<HomeFragmentSliderModel>) {
        view.onDescriptionReceived(list)
    }

    override fun onDescriptionError(error: String) {
        view.onDescriptionError(error)
    }

    override fun onMoviesDownloaded(list: List<HomeFragmentMovieModel>) {
        view.onMoviesResponse(list)
    }

    override fun onMoviesDownloadError(msg: String) {
        view.onMoviesError(msg)
    }
}