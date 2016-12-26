package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.info.IABCUser

/**
 * Created by tengo on 12/26/16.
 */
interface GetUserInfoPICAllback {
    fun onUserLoaded(user: IABCUser?)
}