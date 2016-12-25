package iabc.com.voli.iabcandroid.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import iabc.com.voli.iabcandroid.models.EventDescription
import iabc.com.voli.iabcandroid.ui.fragments.CompanyListFragment
import iabc.com.voli.iabcandroid.ui.fragments.ListOfEventFragment
import iabc.com.voli.iabcandroid.ui.fragments.MarketPlaceFragment
import java.util.*

/**
 * Created by tengo on 12/25/16.
 */
class UserCenterAdapter (frManager: FragmentManager, private val eventList: ArrayList<EventDescription>) : FragmentPagerAdapter(frManager){
    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return MarketPlaceFragment.newInstanseFavourites()
            1-> return CompanyListFragment.newInstaseFavourites()
            else -> return ListOfEventFragment.newInstanse(eventList)
        }
    }

    override fun getCount(): Int {
        return 3
    }
}