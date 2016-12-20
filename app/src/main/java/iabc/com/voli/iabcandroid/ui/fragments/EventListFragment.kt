package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.ui.adapters.EventListFragmentRecyclerListAdapter
import kotlinx.android.synthetic.main.fr_event_list.*
import java.util.*


/**
 * Created by tengo on 12/20/16.
 */
class EventListFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_event_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        fr_event_list_recycler.layoutManager = layoutManager
        fr_event_list_recycler.adapter = EventListFragmentRecyclerListAdapter((1..11).map { EventListFrModel("date = " + it, emptyList())  } as ArrayList<EventListFrModel>, 2)
    }
}