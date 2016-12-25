package iabc.com.voli.iabcandroid.view

import iabc.com.voli.iabcandroid.models.FAQModel

/**
 * Created by tengo on 12/25/16.
 */
interface FAQFagmentView : BaseView{
    fun onQuestionsLoaded(list: List<FAQModel>)
    fun onQuestionLoadFailed(msg: String)
}