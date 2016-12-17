package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MarketPlacePresenterInteractorCallback
import iabc.com.voli.iabcandroid.models.MarketPlaceFrModel

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceInteractor {
    fun startGettingInfo(callback: MarketPlacePresenterInteractorCallback){
        val retList = (1..30).map { MarketPlaceFrModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + it, type = "type = " + it) }

        callback.onContentDowloaded(retList)
    }
}