package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorDescriptionCallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorMoviesCallback
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel
import iabc.com.voli.iabcandroid.ui.fragments.HomeFragment
import java.util.*

/**
 * Created by tengo on 12/14/16.
 */
class HomeFragmentInteractor {

    companion object{
        const val DEF_IMAGE_URL = "http://www.ssaurel.com/tmp/logo_ssaurel.png"
    }

    fun startGettingHomeFragmentDescriptions(callback: HomeFragmentInteractorDescriptionCallback) {
        val retList = ArrayList<HomeFragmentSliderModel>()
        for (i in 1..8) {
            val item = HomeFragmentSliderModel(text="image = " + i)
            retList.add(item)
        }

        callback.onDescriptionDownloaded(retList)
    }

    fun startGettingHomeFragmentRankedMovies(callback: HomeFragmentInteractorMoviesCallback){
        val retList = (1..HomeFragment.movieCount).map { HomeFragmentMovieModel(image= DEF_IMAGE_URL, title = "title = " + it) }
        callback.onMoviesDownloaded(retList)
    }
}