package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel
import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel

/**
 * Created by tengo on 12/14/16.
 */
interface HomeFragmentView : BaseView{
    fun onDescriptionReceived(list: List<HomeFragmentSliderModel>)
    fun onDescriptionError(msg: String)

    fun onMoviesResponse(list: List<HomeFragmentMovieModel>)
    fun onMoviesError(msg: String)
}