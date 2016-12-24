package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.CompanyInnerActModel

/**
 * Created by tengo on 12/24/16.
 */
interface CompanyInnerActView : BaseView {
    fun onModelLoaded(model: CompanyInnerActModel)
    fun onFailed(msg: String)
}