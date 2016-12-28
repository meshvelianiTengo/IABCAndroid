package iabc.com.voli.iabcandroid.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.changeFragment
import iabc.com.voli.iabcandroid.info.IABCUser
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.MenuItemModel
import iabc.com.voli.iabcandroid.presenter.MainActPresenter
import iabc.com.voli.iabcandroid.ui.adapters.MainActMenuAdapter
import iabc.com.voli.iabcandroid.ui.custom.MenuLayout
import iabc.com.voli.iabcandroid.ui.fragments.HomeFragment
import iabc.com.voli.iabcandroid.view.MainActView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_layout_default.*

class MainActivity : AppCompatActivity(), MainActView, MenuLayout.OnMenuAction {

    val presenter = MainActPresenter(this)

    lateinit var mainView: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_main, HomeFragment()).commit()
        initMenu()
    }

    fun initMenu(){
        presenter.startGettingMenu(this)
        act_main_menu.setOnClickListener { openMenu() }
    }

    override fun onItemChosen(index: Int) {
        presenter.onMenuItemChosen(index)
    }

    override fun onMenuClose() {
        closeMenu()
    }

    override fun onLoginRequested() {
        makeToast("jer ar dawerila")
    }

    override fun onMenuItemLoaded(list: List<MenuItemModel>) {
        main_act_menu_view.initContent(list)
        main_act_menu_view.menuActionCallback = this
        presenter.onMenuItemChosen(0)
    }

    override fun onUserLoaded(user: IABCUser) {
        main_act_menu_view.fillHeader(user)
    }

    override fun onNoUserLoggerIn() {
        main_act_menu_view.fillHeaderForNoUser()
    }

    fun getMenuAdapter(list: List<MenuItemModel>): MainActMenuAdapter{
        return MainActMenuAdapter(list, this)
    }

    override fun onChangeFragment(fragment: Fragment) {
        closeMenu()
        changeFragment(R.id.content_main, fragment)
    }


    fun closeMenu(){
        drawer_layout.closeDrawer(Gravity.LEFT)
    }
    fun openMenu(){
        drawer_layout.openDrawer(Gravity.LEFT)
    }
}
