package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.AboutUsPresInterCallback
import iabc.com.voli.iabcandroid.interactors.AboutUsInteractor
import iabc.com.voli.iabcandroid.models.AboutUsFrModel
import iabc.com.voli.iabcandroid.view.AboutUsFrView

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsePresenter(private val view: AboutUsFrView) : BasePresenter(), AboutUsPresInterCallback{

    val interactor = AboutUsInteractor()

    fun startGettingInfo(){
        interactor.startGettingInfo(this)
    }

    override fun onInfoReady(info: AboutUsFrModel) {
        view.onInfoReady(info)
    }
}