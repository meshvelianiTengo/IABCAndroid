package iabc.com.voli.iabcandroid.ui.adapters

import android.content.Context
import android.view.View
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.MenuItemModel
import iabc.com.voli.iabcandroid.ui.adapters.base_adapter.CBaseAdapter
import iabc.com.voli.iabcandroid.ui.custom.MenuView


/**
 * Created by tengo on 12/26/16.
 */
class MainActMenuAdapter(private val list: List<MenuItemModel>, context: Context) : CBaseAdapter(context){

    var activatedItemHolder : ItemHolder? = null

    override fun getItemHolder(v: View): CBaseItemHolder {
        return ItemHolder(v)
    }

    override fun getLayoutResId(): Int {
        return R.layout.main_act_menu_adapter_item
    }

    override fun getItem(p0: Int): MenuItemModel {
        return list[p0]
    }

    override fun getCount(): Int {
        return list.size
    }

    inner class ItemHolder(view: View) : CBaseItemHolder(view){
        private val menuView : MenuView

        init {
            menuView = view.findViewById(R.id.main_act_menu_adapter_item_view) as MenuView
        }
        override fun fillViews(position: Int) {
            menuView.setContent(list[position])
        }

        fun activate(){
            menuView.activate()
        }
        fun deactivate(){
            menuView.deactivate()
        }
    }

    fun activateItem(v: View){
        val holder = v.tag as ItemHolder
        if(activatedItemHolder == null){
            activatedItemHolder = holder
        }else{
            activatedItemHolder?.deactivate()
            activatedItemHolder = holder
        }
        activatedItemHolder?.activate()
    }
}
