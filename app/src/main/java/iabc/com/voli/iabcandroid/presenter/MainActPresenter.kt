package iabc.com.voli.iabcandroid.presenter

import android.content.Context
import android.support.v4.app.Fragment
import iabc.com.voli.iabcandroid.info.IABCUser
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.GetUserInfoPICAllback
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MainActPICallback
import iabc.com.voli.iabcandroid.interactors.MainActInteractor
import iabc.com.voli.iabcandroid.interactors.UserInteractor
import iabc.com.voli.iabcandroid.models.MenuItemModel
import iabc.com.voli.iabcandroid.ui.fragments.*
import iabc.com.voli.iabcandroid.view.MainActView

/**
 * Created by tengo on 12/26/16.
 */
class MainActPresenter(private val view: MainActView) : BasePresenter(), MainActPICallback, GetUserInfoPICAllback {
    val menuIntetactor = MainActInteractor()
    val userInteractor = UserInteractor()

    fun startGettingMenu(context: Context){
        menuIntetactor.initMenuItems(this)
        userInteractor.getLoggedInUser(context, this)
    }

    override fun onMenuLoaded(list: List<MenuItemModel>) {
        view.onMenuItemLoaded(list)
    }

    override fun onUserLoaded(user: IABCUser?) {
        if(user == null)
            view.onNoUserLoggerIn()
        else
            view.onUserLoaded(user)
    }

    fun onMenuItemChosen(menuItemId: Int) {
        val fr: Fragment = when(menuItemId){
            0 -> HomeFragment()
            1-> MarketPlaceFragment.newInstanse()
            2-> CompanyListFragment.newInstanse()
            3-> EventListFragment()
            4-> AboutIABCFragment()
            else -> FAQFragment()

        }
        view.onChangeFragment(fr)

    }
}