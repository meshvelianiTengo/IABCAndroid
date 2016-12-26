package iabc.com.voli.iabcandroid.view

import android.support.v4.app.Fragment
import iabc.com.voli.iabcandroid.info.IABCUser
import iabc.com.voli.iabcandroid.models.MenuItemModel

/**
 * Created by tengo on 12/26/16.
 */
interface MainActView : BaseView{
    fun onMenuItemLoaded(list: List<MenuItemModel>)
    fun onUserLoaded(user: IABCUser)
    fun onNoUserLoggerIn()

    fun onChangeFragment(fragment: Fragment)
}