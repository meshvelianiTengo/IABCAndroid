package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.ItemInnerFrPICalback
import iabc.com.voli.iabcandroid.interactors.ItemInnerFrInteractor
import iabc.com.voli.iabcandroid.models.ItemInnerFrModel
import iabc.com.voli.iabcandroid.view.ItemInnerFrView

/**
 * Created by tengo on 12/20/16.
 */
class ItemInnerFrPresenter(private val view: ItemInnerFrView) : BasePresenter(), ItemInnerFrPICalback {

    private val interactor = ItemInnerFrInteractor()

    fun startGettingInfo(itemId: String){
        interactor.startGettingItemInfo(itemId, this)
    }

    override fun onSuccess(model: ItemInnerFrModel) {
        view.onModelLoaded(model)
    }

    override fun onError(msg: String) {
        view.onError(msg)
    }
}