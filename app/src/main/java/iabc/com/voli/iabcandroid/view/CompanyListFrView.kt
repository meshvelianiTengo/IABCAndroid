package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.CompanyListFrModel

/**
 * Created by tengo on 12/23/16.
 */
interface CompanyListFrView : BaseView{
    fun onListLoaded(list: List<CompanyListFrModel>)
    fun onFailed(msg: String)
}