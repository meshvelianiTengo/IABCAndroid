package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventInnerPICallback
import iabc.com.voli.iabcandroid.interactors.EventInnerInteractor
import iabc.com.voli.iabcandroid.models.EventInnerFrModel
import iabc.com.voli.iabcandroid.view.EventInnerFrView

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerPresenter(private val view: EventInnerFrView) : BasePresenter(), EventInnerPICallback {

    val interactor = EventInnerInteractor()

    fun startGettinInfo(eventId: String){
        interactor.startGettingEvent(eventId, this)
    }

    override fun onSuccess(model: EventInnerFrModel) {
        view.onSuccess(model)
    }

    override fun onError(msg: String) {
        view.onError(msg)
    }
}