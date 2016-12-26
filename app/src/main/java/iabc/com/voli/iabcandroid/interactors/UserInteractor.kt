package iabc.com.voli.iabcandroid.interactors

import android.content.Context
import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.GetUserInfoPICAllback

/**
 * Created by tengo on 12/26/16.
 */
class UserInteractor {
    fun getLoggedInUser(context: Context, callback: GetUserInfoPICAllback){
        callback.onUserLoaded(null)
    }
}