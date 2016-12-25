package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.CompanyListPICallback
import iabc.com.voli.iabcandroid.models.CompanyListFrModel

/**
 * Created by tengo on 12/23/16.
 */
class CompaniListFrInteractor {
    fun startGettingInfo(callback: CompanyListPICallback, isFavourites: Boolean = false){
        if(isFavourites) {
            callback.onListLoaded((1..10).map { CompanyListFrModel("company " + it, HomeFragmentInteractor.DEF_IMAGE_URL) })
        }else{
            callback.onListLoaded((1..3).map { CompanyListFrModel("company " + it, HomeFragmentInteractor.DEF_IMAGE_URL) })
        }
    }
}