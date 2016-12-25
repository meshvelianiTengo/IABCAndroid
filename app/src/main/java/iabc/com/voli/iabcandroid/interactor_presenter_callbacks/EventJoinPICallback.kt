package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.EventInnerModel

/**
 * Created by tengo on 12/25/16.
 */
interface EventJoinPICallback {
    fun onJoinedFinished(model: EventInnerModel)
    fun onJoinFailed(msg: String)
}