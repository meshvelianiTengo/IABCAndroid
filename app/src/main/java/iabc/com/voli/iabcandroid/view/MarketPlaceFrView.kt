package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.MarketPlaceFrModel

/**
 * Created by tengo on 12/17/16.
 */
interface MarketPlaceFrView : BaseView{
    fun onContentDowloaded(list: List<MarketPlaceFrModel>)
    fun onContentError(msg: String)
}