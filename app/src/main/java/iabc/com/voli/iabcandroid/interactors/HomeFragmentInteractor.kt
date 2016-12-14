package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorDescriptionCallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.HomeFragmentInteractorMoviesCallback
import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel
import java.util.*

/**
 * Created by tengo on 12/14/16.
 */
class HomeFragmentInteractor {

    companion object{
        const val DEF_IMAGE_URL = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRuhO9tzTHjJI39XEduni7DFbmBXWlHn6s_4K58J8mYdUwofoCr3Q"
    }

    fun startGettingHomeFragmentDescriptions(callback: HomeFragmentInteractorDescriptionCallback) {
        val retList = ArrayList<HomeFragmentSliderModel>()
        for (i in 1..8) {
            val item = HomeFragmentSliderModel(text="image = " + i, image= DEF_IMAGE_URL)
            retList.add(item)
        }

        callback.onDescriptionDownloaded(retList)
    }

    fun startGettingHomeFragmentRankedMovies(callback: HomeFragmentInteractorMoviesCallback){
        val retList = ArrayList<HomeFragmentMovieModel>()
        for(i in 1..8){
            val item = HomeFragmentMovieModel(image= DEF_IMAGE_URL, title = "title = " +i)
            retList.add(item)
        }
        callback.onMoviesDownloaded(retList)
    }
}