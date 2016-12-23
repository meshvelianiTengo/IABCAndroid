package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.CompanyListPICallback
import iabc.com.voli.iabcandroid.interactors.CompaniListFrInteractor
import iabc.com.voli.iabcandroid.models.CompanyListFrModel
import iabc.com.voli.iabcandroid.view.CompanyListFrView

/**
 * Created by tengo on 12/23/16.
 */
class CompanyListFrPresenter(private val view: CompanyListFrView) : BasePresenter(), CompanyListPICallback{

    val interactor = CompaniListFrInteractor()

    fun startGettingInfo(){
        interactor.startGettingInfo(this)
    }

    override fun onListLoaded(list: List<CompanyListFrModel>) {
        view.onListLoaded(list)
    }

    override fun onFailed(msg: String) {
        view.onFailed(msg)
    }
}