package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.FAQPICallback
import iabc.com.voli.iabcandroid.interactors.FAQInteractor
import iabc.com.voli.iabcandroid.models.FAQModel
import iabc.com.voli.iabcandroid.view.FAQFagmentView

/**
 * Created by tengo on 12/25/16.
 */
class FAQPresenter(private val view: FAQFagmentView) : BasePresenter(), FAQPICallback {

    val faqInteractor = FAQInteractor()

    fun startGettingInfo(){
        faqInteractor.startGettinInfo(this)
    }

    override fun onQuestionsLoaded(list: List<FAQModel>) {
        view.onQuestionsLoaded(list)
    }

    override fun onQuestionLoadFailed(msg: String) {
        view.onQuestionLoadFailed(msg)
    }
}