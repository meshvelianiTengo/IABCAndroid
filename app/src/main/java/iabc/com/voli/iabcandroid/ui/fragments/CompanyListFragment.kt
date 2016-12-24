package iabc.com.voli.iabcandroid.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.CompanyListFrModel
import iabc.com.voli.iabcandroid.presenter.CompanyListFrPresenter
import iabc.com.voli.iabcandroid.ui.CompanyInnerActivity
import iabc.com.voli.iabcandroid.ui.adapters.CompanyListFrAdapter
import iabc.com.voli.iabcandroid.view.CompanyListFrView
import kotlinx.android.synthetic.main.fr_company_list.*

/**
 * Created by tengo on 12/23/16.
 */
class CompanyListFragment : BaseFragment(), CompanyListFrView{

    val presenter = CompanyListFrPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_company_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingInfo()
    }

    override fun onListLoaded(list: List<CompanyListFrModel>) {
        fr_company_list.adapter = CompanyListFrAdapter(context, list)
        fr_company_list.setOnItemClickListener { adapterView, view, i, l -> pushCompanyInner(i) }
    }

    override fun onFailed(msg: String) {
        makeToast("crush " + msg)
    }

    fun pushCompanyInner(id: Int){
        val intent = Intent(context, CompanyInnerActivity::class.java)
        intent.putExtra(CompanyInnerActivity.BUNDLE_COMPANY_ID, id.toString())
        startActivity(intent)
    }

}