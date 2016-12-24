package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MarketPlacePresenterInteractorCallback
import iabc.com.voli.iabcandroid.models.MovieItemModel
import java.util.*

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceInteractor {
    fun startGettingInfo(list: List<Boolean>, callback: MarketPlacePresenterInteractorCallback){
        val retList = list.indices
                .filter { list[it] }
                .mapTo(ArrayList<MovieItemModel>()) { MovieItemModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + it, type = "type = " + it) }
        //        val retList = (1..3).map { MovieItemModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + it, type = "type = " + it) }

        callback.onContentDowloaded(retList)
    }
}