package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.presenter.EventListFrPresenter
import iabc.com.voli.iabcandroid.ui.adapters.EventListFragmentRecyclerListAdapter
import iabc.com.voli.iabcandroid.view.EventListFrView
import kotlinx.android.synthetic.main.fr_event_list.*


/**
 * Created by tengo on 12/20/16.
 */
class EventListFragment : BaseFragment(), EventListFrView, EventListFragmentRecyclerListAdapter.OnListItemChosen {

    val presenter = EventListFrPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_event_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.startGettinInfo()
        fr_event_list_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onSuccess(list: List<EventListFrModel>) {
        val adapter = EventListFragmentRecyclerListAdapter(list, 2)
        adapter.itemChosenListener = this
        fr_event_list_recycler.adapter = adapter
    }

    override fun onItemChosen(item: EventListFrModel, position: Int) {
        makeToast("position = " + position)
    }

    override fun onFailed(msg: String) {
        throw UnsupportedOperationException("not implemented")
    }
}