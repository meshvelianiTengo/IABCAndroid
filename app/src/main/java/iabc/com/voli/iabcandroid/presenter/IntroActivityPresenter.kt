package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.models.IntroActivityModel
import iabc.com.voli.iabcandroid.view.IntroActivityView
import java.util.*

/**
 * Created by tengo on 12/12/16.
 */
class IntroActivityPresenter(val view: IntroActivityView) {


    fun checkFirstLaunch(){
        val items = ArrayList<IntroActivityModel>()
        for(i in 1..6) {
            items.add(IntroActivityModel("title = " + i, "content = " + i))
        }
        view.onFirstLaunch(items)
    }
}