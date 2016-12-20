package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventListPICallback
import iabc.com.voli.iabcandroid.models.EventListFrModel
import java.util.*

/**
 * Created by tengo on 12/20/16.
 */
class EventListFrInteractor {
    fun startGettingInfo(callback: EventListPICallback){
        callback.onSuccess((1..11).map { EventListFrModel("date = " + it, emptyList())  } as ArrayList<EventListFrModel>)
    }
}