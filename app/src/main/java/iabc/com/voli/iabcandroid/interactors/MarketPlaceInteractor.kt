package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MarketPlacePresenterInteractorCallback
import iabc.com.voli.iabcandroid.models.MarketPlaceFrModel
import java.util.*

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceInteractor {
    fun startGettingInfo(list: List<Boolean>, callback: MarketPlacePresenterInteractorCallback){
        val retList = ArrayList<MarketPlaceFrModel>()
        for(i in list.indices){
            if(list[i]){
                retList.add(MarketPlaceFrModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + i, type = "type = " + i))

            }
        }
//        val retList = (1..3).map { MarketPlaceFrModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + it, type = "type = " + it) }

        callback.onContentDowloaded(retList)
    }
}