package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.FAQModel

/**
 * Created by tengo on 12/25/16.
 */
interface FAQPICallback : BasePICallback{
    fun onQuestionsLoaded(list: List<FAQModel>)
    fun onQuestionLoadFailed(msg: String)
}