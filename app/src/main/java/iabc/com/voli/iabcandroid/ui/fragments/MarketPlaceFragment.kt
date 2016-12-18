package iabc.com.voli.iabcandroid.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.MarketPlaceFrModel
import iabc.com.voli.iabcandroid.presenter.MarketPlacePresenter
import iabc.com.voli.iabcandroid.ui.adapters.MarketPlaceAdapter
import iabc.com.voli.iabcandroid.view.MarketPlaceFrView
import kotlinx.android.synthetic.main.fragment_market_place.*

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceFragment: BaseFragment(), MarketPlaceFrView{

    val presenter: MarketPlacePresenter

    init {
        presenter = MarketPlacePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_market_place, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingInfo()
    }


    override fun onContentDowloaded(list: List<MarketPlaceFrModel>) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val listPadding = inflater.inflate(R.layout.fragment_market_place_list_footer, null)
        fr_market_place_list.addFooterView(listPadding)
        fr_market_place_list.addHeaderView(listPadding)
        fr_market_place_list.adapter = getAdapter(list)
    }

    fun getAdapter(list: List<MarketPlaceFrModel>) : MarketPlaceAdapter{
        return MarketPlaceAdapter(context, list)
    }

    override fun onContentError(msg: String) {
        makeToast(msg)
    }
}