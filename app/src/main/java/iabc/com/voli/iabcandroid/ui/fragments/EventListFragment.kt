package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.presenter.EventListFrPresenter
import iabc.com.voli.iabcandroid.ui.adapters.EventListFragmentRecyclerListAdapter
import iabc.com.voli.iabcandroid.view.EventListFrView
import kotlinx.android.synthetic.main.fr_event_list.*


/**
 * Created by tengo on 12/20/16.
 */
class EventListFragment : BaseFragment(), EventListFrView {

    val presenter = EventListFrPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_event_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        presenter.startGettinInfo()


        fr_event_list_recycler.layoutManager = layoutManager
    }

    override fun onSuccess(list: List<EventListFrModel>) {
        fr_event_list_recycler.adapter = EventListFragmentRecyclerListAdapter(list, 2)

    }

    override fun onFailed(msg: String) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}