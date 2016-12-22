package iabc.com.voli.iabcandroid.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.ui.fragments.ListOfEventFragment

/**
 * Created by tengo on 12/22/16.
 */
class EventListFrPagerAdapter(private val eventList: List<EventListFrModel>, frManager: FragmentManager) : FragmentPagerAdapter(frManager) {

    override fun getItem(position: Int): Fragment {
        return ListOfEventFragment.newInstanse(eventList[position].eventList)
    }

    override fun getCount(): Int {
        return eventList.size
    }
}