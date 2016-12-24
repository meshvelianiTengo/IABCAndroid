package iabc.com.voli.iabcandroid.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrl
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.CompanyInnerActModel
import iabc.com.voli.iabcandroid.models.ContactInfoModel
import iabc.com.voli.iabcandroid.presenter.CompanyInnerPresenter
import iabc.com.voli.iabcandroid.ui.adapters.CompanyInnerListAdapter
import iabc.com.voli.iabcandroid.view.CompanyInnerActView
import kotlinx.android.synthetic.main.activity_company_inner.*

class CompanyInnerActivity : AppCompatActivity(), CompanyInnerActView {

    companion object{
        const val BUNDLE_COMPANY_ID = "company_inner_bundle_id"
    }

    val presenter = CompanyInnerPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_inner)
        act_company_inner_movie_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        presenter.startGettingInfo(intent?.extras)
    }

    override fun onModelLoaded(model: CompanyInnerActModel) {
        act_company_inner_image.loadImageFromUrl(model.imageUrl)
        //Glide.with(this).load(model.imageUrl).into(
        if(model.contactInfo != null) {
            act_company_inner_contact_info.visibility = View.VISIBLE
            act_company_inner_contact_info.setContactInfo(model.contactInfo as ContactInfoModel)
        } else act_company_inner_contact_info.visibility = View.GONE

        val movieCount = model.movieItemModel.size
        act_company_inner_movie_count.text = movieCount.toString()

        act_company_inner_movie_list.adapter = CompanyInnerListAdapter(model.movieItemModel)
    }

    override fun onFailed(msg: String) {
        makeToast(msg)
    }
}
