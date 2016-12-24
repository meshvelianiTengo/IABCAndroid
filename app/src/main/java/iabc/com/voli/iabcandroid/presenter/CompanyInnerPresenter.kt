package iabc.com.voli.iabcandroid.presenter

import android.os.Bundle
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.CompanyInnerActPICallback
import iabc.com.voli.iabcandroid.interactors.CompanyInnerInteractor
import iabc.com.voli.iabcandroid.models.CompanyInnerActModel
import iabc.com.voli.iabcandroid.ui.CompanyInnerActivity
import iabc.com.voli.iabcandroid.view.CompanyInnerActView

/**
 * Created by tengo on 12/24/16.
 */
class CompanyInnerPresenter(private val view: CompanyInnerActView): BasePresenter(), CompanyInnerActPICallback{
    val interactor = CompanyInnerInteractor()

    fun startGettingInfo(bundle: Bundle?){
        if(bundle != null && bundle.containsKey(CompanyInnerActivity.BUNDLE_COMPANY_ID)) {
            val id = bundle.getString(CompanyInnerActivity.BUNDLE_COMPANY_ID)
            interactor.startGettingInfo(id, this)
        }else{
            view.onFailed("no company id")
        }
    }

    override fun onModelLoaded(model: CompanyInnerActModel) {
        view.onModelLoaded(model)
    }

    override fun onFailed(msg: String) {
        view.onFailed(msg)
    }
}