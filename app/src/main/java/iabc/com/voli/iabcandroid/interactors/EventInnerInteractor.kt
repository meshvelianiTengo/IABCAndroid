package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventInnerPICallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventJoinPICallback
import iabc.com.voli.iabcandroid.models.EventInnerModel

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerInteractor {

    fun startGettingEvent(eventId: String, callback: EventInnerPICallback){
        callback.onSuccess(EventInnerModel(HomeFragmentInteractor.DEF_IMAGE_URL, "name", "location", "10:10", "10:20", "11.11.11", desc = "desc"))
    }

    fun changeJoinStatus(model: EventInnerModel, callback: EventJoinPICallback){
        model.isJoined = !model.isJoined
        callback.onJoinedFinished(model)
    }
}