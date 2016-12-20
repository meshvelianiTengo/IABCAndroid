package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.EventListFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventListPICallback : BasePICallback {
    fun onSuccess(list: List<EventListFrModel>)
    fun onFailed(msg: String)

}