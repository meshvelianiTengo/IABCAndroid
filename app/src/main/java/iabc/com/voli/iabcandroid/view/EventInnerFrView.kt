package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.EventInnerFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventInnerFrView {
    fun onSuccess(model: EventInnerFrModel)
    fun onError(msg: String)
}