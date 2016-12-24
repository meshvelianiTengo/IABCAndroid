package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.CompanyInnerActPICallback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.CompanyInnerWatchingPICallback
import iabc.com.voli.iabcandroid.models.CompanyInnerActModel
import iabc.com.voli.iabcandroid.models.ContactInfoModel
import iabc.com.voli.iabcandroid.models.MovieItemModel

/**
 * Created by tengo on 12/24/16.
 */
class CompanyInnerInteractor {
    fun startGettingInfo(companyId: String, callback: CompanyInnerActPICallback){
        callback.onModelLoaded(CompanyInnerActModel(1, HomeFragmentInteractor.DEF_IMAGE_URL, ContactInfoModel("name", "email", "mobile"), companyId, "a lot of desc", (1..10).map{ MovieItemModel(imageUrl= HomeFragmentInteractor.DEF_IMAGE_URL, name = "title = " + it, type = "type = " + it) } ))
    }
    fun changeWatchingStatus(model: CompanyInnerActModel, callback: CompanyInnerWatchingPICallback){
        model.isWatching = !model.isWatching
        callback.onWatchingSuccess(model)
    }
}