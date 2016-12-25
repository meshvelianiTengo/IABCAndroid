package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.EventInnerModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventInnerView {
    fun onSuccess(model: EventInnerModel)
    fun onError(msg: String)

    fun onEventJoined(model: EventInnerModel)
    fun onEventUnjoined(model: EventInnerModel)
    fun onJoinFailed(msg: String)
}