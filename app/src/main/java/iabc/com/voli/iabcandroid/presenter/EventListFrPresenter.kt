package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.EventListPICallback
import iabc.com.voli.iabcandroid.interactors.EventListFrInteractor
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.view.EventListFrView

/**
 * Created by tengo on 12/20/16.
 */
class EventListFrPresenter(private val view: EventListFrView) : BasePresenter(), EventListPICallback {

    val interactor = EventListFrInteractor()

    fun startGettinInfo(){
        interactor.startGettingInfo(this)
    }

    override fun onSuccess(list: List<EventListFrModel>) {
        view.onSuccess(list)
    }

    override fun onFailed(msg: String) {
        view.onFailed(msg)
    }
}