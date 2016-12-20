package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.EventListFrModel

/**
 * Created by tengo on 12/20/16.
 */
interface EventListFrView {
    fun onSuccess(list: List<EventListFrModel>)
    fun onFailed(msg: String)
}