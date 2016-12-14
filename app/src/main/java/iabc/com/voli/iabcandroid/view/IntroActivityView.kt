package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.IntroActivityModel

/**
 * Created by tengo on 12/12/16.
 */
interface IntroActivityView : BaseView {
    fun onFirstLaunch(list : List<IntroActivityModel>)
    fun onPushMain()
}