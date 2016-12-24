package iabc.com.voli.iabcandroid.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.MovieItemModel
import iabc.com.voli.iabcandroid.presenter.MarketPlacePresenter
import iabc.com.voli.iabcandroid.ui.adapters.MarketPlaceAdapter
import iabc.com.voli.iabcandroid.ui.custom.MenuFilterLayout
import iabc.com.voli.iabcandroid.view.MarketPlaceFrView
import kotlinx.android.synthetic.main.fragment_market_place.*
import java.util.*

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceFragment: BaseFragment(), MarketPlaceFrView, MenuFilterLayout.MenuFilterCallback{

    val presenter: MarketPlacePresenter
    val activatedItems = (0..4).map { false } as ArrayList<Boolean>

    init {
        presenter = MarketPlacePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_market_place, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        refreshContent()
    }

    private fun initViews(){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val listPadding = inflater.inflate(R.layout.fragment_market_place_list_footer, null)
        fr_market_place_list.addFooterView(listPadding)
        fr_market_place_list.addHeaderView(listPadding)
        fr_market_place_menu_filter.callback = this
    }

    private fun refreshContent(){
        presenter.startGettingInfo(activatedItems)
    }



    override fun onContentDowloaded(list: List<MovieItemModel>) {
        fr_market_place_list.adapter = getAdapter(list)
        fr_market_place_list.setOnItemClickListener { adapterView, view, i, l -> showFilter() }
    }


    fun showFilter(){
        fr_market_place_menu_filter.show()
    }

    fun getAdapter(list: List<MovieItemModel>) : MarketPlaceAdapter{
        return MarketPlaceAdapter(context, list)
    }

    override fun onContentError(msg: String) {
        makeToast(msg)
    }

    override fun stateChanged(isOpen: Boolean) {

    }

    override fun onItemClicked(itemId: Int, activated: Boolean) {
        if(activatedItems[itemId] != activated){
            activatedItems.set(itemId, activated)
            refreshContent();
        }
    }
}