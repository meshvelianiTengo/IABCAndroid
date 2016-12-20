package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.ItemInnerFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface ItemInnerFrPICalback : BasePICallback{
    fun onSuccess(model: ItemInnerFrModel)
    fun onError(msg: String)
}
