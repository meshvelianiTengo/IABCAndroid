package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.CompanyInnerActModel

/**
 * Created by tengo on 12/24/16.
 */
interface CompanyInnerActPICallback : BasePICallback{
    fun onModelLoaded(model: CompanyInnerActModel)
    fun onFailed(msg: String)
}