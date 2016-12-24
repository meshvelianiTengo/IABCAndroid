package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.CompanyInnerActModel

/**
 * Created by tengo on 12/24/16.
 */
interface CompanyInnerWatchingPICallback {
    fun onWatchingSuccess(model: CompanyInnerActModel)
    fun onWathingFailed(model: CompanyInnerActModel)
}