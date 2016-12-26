package iabc.com.voli.iabcandroid.models

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import iabc.com.voli.iabcandroid.R

/**
 * Created by tengo on 12/26/16.
 */
class MenuItemModel(@StringRes val name: Int, @DrawableRes val resId: Int){
    companion object{
        val MENU_LIST = listOf<MenuItemModel>(MenuItemModel(R.string.menu_name_home, R.mipmap.home), MenuItemModel(R.string.menu_name_marketplace, R.mipmap.cart), MenuItemModel(R.string.menu_name_companies, R.mipmap.briefcase), MenuItemModel(R.string.menu_name_events, R.mipmap.calendar)
                , MenuItemModel(R.string.menu_name_about, R.mipmap.menu_icon_about), MenuItemModel(R.string.menu_name_f_a_q, R.mipmap.menu_icon_f_a_q))
    }
}