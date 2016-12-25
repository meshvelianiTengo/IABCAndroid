package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventInnerPICallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventJoinPICallback
import iabc.com.voli.iabcandroid.interactors.EventInnerInteractor
import iabc.com.voli.iabcandroid.models.EventInnerModel
import iabc.com.voli.iabcandroid.view.EventInnerView

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerPresenter(private val view: EventInnerView) : BasePresenter(), EventInnerPICallback, EventJoinPICallback {

    val interactor = EventInnerInteractor()

    fun startGettinInfo(eventId: String){
        interactor.startGettingEvent(eventId, this)
    }

    fun changeJoinStatus(model: EventInnerModel?) {
        if(model != null){
            interactor.changeJoinStatus(model, this);
        }
    }


    override fun onSuccess(model: EventInnerModel) {
        view.onSuccess(model)
    }

    override fun onError(msg: String) {
        view.onError(msg)
    }


    override fun onJoinedFinished(model: EventInnerModel) {
        if(model.isJoined) view.onEventJoined(model)
        else view.onEventUnjoined(model)
    }

    override fun onJoinFailed(msg: String) {
        view.onJoinFailed(msg)
    }
}