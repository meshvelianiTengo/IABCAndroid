package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.HomeFragmentMovieModel

/**
 * Created by tengo on 12/14/16.
 */
interface HomeFragmentInteractorMoviesCallback : BasePICallback {
    fun onMoviesDownloaded(list: List<HomeFragmentMovieModel>)
    fun onMoviesDownloadError(msg: String)
}