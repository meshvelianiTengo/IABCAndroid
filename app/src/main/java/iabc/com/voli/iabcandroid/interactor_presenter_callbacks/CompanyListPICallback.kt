package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.CompanyListFrModel

/**
 * Created by tengo on 12/23/16.
 */
interface CompanyListPICallback : BasePICallback{
    fun onListLoaded(list: List<CompanyListFrModel>)
    fun onFailed(msg: String)
}