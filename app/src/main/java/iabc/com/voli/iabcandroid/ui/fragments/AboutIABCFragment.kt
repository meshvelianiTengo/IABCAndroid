package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.AboutUsFrModel
import iabc.com.voli.iabcandroid.presenter.AboutUsePresenter
import iabc.com.voli.iabcandroid.ui.adapters.AboutUsPagerAdapter
import iabc.com.voli.iabcandroid.view.AboutUsFrView
import kotlinx.android.synthetic.main.fragment_about_us.*

/**
 * Created by tengo on 12/18/16.
 */
class AboutIABCFragment : BaseFragment(), AboutUsFrView{

    val presenter = AboutUsePresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingInfo()

        about_us_fr_more_info.setOnClickListener { loadMoreInfoAboutIABC() }
    }

    private fun loadMoreInfoAboutIABC() {
        makeToast("es jer ar vici")
    }


    override fun onInfoReady(info: AboutUsFrModel) {

        fr_about_us_contact_info.setContactInfo(info.contactInfo)

        fr_about_us_pager.adapter = AboutUsPagerAdapter(context, info.textList)
        fr_about_us_tablayout.setupWithViewPager(fr_about_us_pager, true)
    }
}