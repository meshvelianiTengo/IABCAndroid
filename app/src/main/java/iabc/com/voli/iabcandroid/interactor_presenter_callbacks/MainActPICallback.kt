package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.MenuItemModel

/**
 * Created by tengo on 12/26/16.
 */
interface MainActPICallback : BasePICallback{
    fun onMenuLoaded(list: List<MenuItemModel>)
}