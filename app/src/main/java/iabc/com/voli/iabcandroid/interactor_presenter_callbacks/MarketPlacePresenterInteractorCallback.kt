package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.MarketPlaceFrModel

/**
 * Created by tengo on 12/17/16.
 */
interface MarketPlacePresenterInteractorCallback : BasePICallback {
    fun onContentDowloaded(list: List<MarketPlaceFrModel>)
    fun onContentError(msg: String)
}