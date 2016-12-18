package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.AboutUsPresInterCallback
import iabc.com.voli.iabcandroid.models.AboutUsFrModel

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsInteractor {

    fun startGettingInfo(callback: AboutUsPresInterCallback){
        callback.onInfoReady(AboutUsFrModel((1..5).map{"title = " + it}, AboutUsFrModel.ContactInfo("my location", "my mail", "my mobile")))
    }
}