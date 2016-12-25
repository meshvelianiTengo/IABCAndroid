package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.EventInnerModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventInnerPICallback : BasePICallback{
    fun onSuccess(model: EventInnerModel)
    fun onError(msg: String)

}