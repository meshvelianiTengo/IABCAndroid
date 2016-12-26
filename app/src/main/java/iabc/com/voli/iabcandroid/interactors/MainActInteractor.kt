package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MainActPICallback
import iabc.com.voli.iabcandroid.models.MenuItemModel

/**
 * Created by tengo on 12/26/16.
 */
class MainActInteractor {
    fun initMenuItems(callback: MainActPICallback){
        callback.onMenuLoaded(MenuItemModel.MENU_LIST)
    }
}