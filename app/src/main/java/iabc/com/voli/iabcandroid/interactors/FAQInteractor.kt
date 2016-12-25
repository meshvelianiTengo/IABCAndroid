package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.FAQPICallback
import iabc.com.voli.iabcandroid.models.FAQModel

/**
 * Created by tengo on 12/25/16.
 */
class FAQInteractor {
    fun startGettinInfo(callback: FAQPICallback){
        callback.onQuestionsLoaded((1..10).map{ FAQModel("question: " + it, "answear: " + it) })
    }
}