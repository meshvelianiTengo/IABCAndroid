package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.FAQModel
import iabc.com.voli.iabcandroid.presenter.FAQPresenter
import iabc.com.voli.iabcandroid.ui.adapters.FAQAdapter
import iabc.com.voli.iabcandroid.view.FAQFagmentView
import kotlinx.android.synthetic.main.fragment_faq.*

/**
 * Created by tengo on 12/25/16.
 */
class FAQFragment : BaseFragment(), FAQFagmentView{

    val presenter = FAQPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_faq, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingInfo()
    }

    override fun onQuestionsLoaded(list: List<FAQModel>) {
        fr_faq_list.adapter = FAQAdapter(list, context)
    }

    override fun onQuestionLoadFailed(msg: String) {
        makeToast(msg)
    }
}