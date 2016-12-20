package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.ItemInnerFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface ItemInnerFrView : BaseView{
    fun onModelLoaded(model: ItemInnerFrModel)
    fun onError(msg: String)
}