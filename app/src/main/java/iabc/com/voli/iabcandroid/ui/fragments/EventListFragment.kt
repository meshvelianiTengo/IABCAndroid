package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.presenter.EventListFrPresenter
import iabc.com.voli.iabcandroid.ui.adapters.EventListFrPagerAdapter
import iabc.com.voli.iabcandroid.ui.adapters.EventListFragmentRecyclerListAdapter
import iabc.com.voli.iabcandroid.view.EventListFrView
import kotlinx.android.synthetic.main.fr_event_list.*


/**
 * Created by tengo on 12/20/16.
 */
class EventListFragment : BaseFragment(), EventListFrView, EventListFragmentRecyclerListAdapter.OnListItemChosen
        ,ViewPager.OnPageChangeListener {

    val presenter = EventListFrPresenter(this)
    var pagerAdapter : EventListFrPagerAdapter? = null
    var recyclerAdapter : EventListFragmentRecyclerListAdapter? = null

    var pagerScrolledAtLeastOnce = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_event_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.startGettinInfo()
        fr_event_list_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onSuccess(list: List<EventListFrModel>) {
        recyclerAdapter = EventListFragmentRecyclerListAdapter(list, 2)
        recyclerAdapter?.itemChosenListener = this
        fr_event_list_recycler.adapter = recyclerAdapter

        pagerAdapter = EventListFrPagerAdapter(list, fragmentManager)
        fr_event_list_pager.adapter = pagerAdapter
        fr_event_list_pager.addOnPageChangeListener(this)


    }

    override fun eventListFrRListAdapter_onItemChosen(item: EventListFrModel, position: Int) {
        fr_event_list_pager.setCurrentItem(position)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if(position > 0){
            pagerScrolledAtLeastOnce = true
        }
    }

    override fun onPageSelected(position: Int) {
        if(pagerScrolledAtLeastOnce) {
            recyclerAdapter?.activateItemWithPosition(position)
//            val scrollX : Int = fr_event_list_recycler.getChildAt(0).width * (position - 1)

            fr_event_list_recycler.layoutManager.smoothScrollToPosition(fr_event_list_recycler, RecyclerView.State(), position)
        }
    }

    override fun onFailed(msg: String) {
        throw UnsupportedOperationException("not implemented")
    }
}