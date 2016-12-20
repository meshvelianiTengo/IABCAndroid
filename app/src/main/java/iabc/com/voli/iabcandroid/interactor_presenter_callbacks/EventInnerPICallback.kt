package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.EventInnerFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventInnerPICallback : BasePICallback{
    fun onSuccess(model: EventInnerFrModel)
    fun onError(msg: String)
}