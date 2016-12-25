package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventDescription
import iabc.com.voli.iabcandroid.ui.adapters.UserCenterAdapter
import kotlinx.android.synthetic.main.fr_user_center.*
import java.util.*

/**
 * Created by tengo on 12/25/16.
 */
class UserCenterFragment : BaseFragment(){

    lateinit var pagerAdapter : UserCenterAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_user_center, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = UserCenterAdapter(fragmentManager, (1..3).map { EventDescription("name", "cat", "loc") } as ArrayList<EventDescription>)
        fr_user_center_pager.adapter = pagerAdapter
        initPager()
    }

    fun initPager(){

    }

}

