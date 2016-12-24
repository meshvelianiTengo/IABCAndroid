package iabc.com.voli.iabcandroid.ui

import android.graphics.Color
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
import iabc.com.voli.iabcandroid.setTextOrGone
import iabc.com.voli.iabcandroid.ui.adapters.CompanyInnerListAdapter
import iabc.com.voli.iabcandroid.view.CompanyInnerActView
import kotlinx.android.synthetic.main.activity_company_inner.*
import kotlinx.android.synthetic.main.app_bar_layout_default.*

class CompanyInnerActivity : AppCompatActivity(), CompanyInnerActView {

    companion object{
        const val BUNDLE_COMPANY_ID = "company_inner_bundle_id"
    }

    val presenter = CompanyInnerPresenter(this)
    var currentModel : CompanyInnerActModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_inner)
        initMenu()
        act_company_inner_movie_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        presenter.startGettingInfo(intent?.extras)
    }

    fun initMenu(){
        act_main_option_menu.setImageResource(R.mipmap.eye_icon)
        act_main_option_menu.setOnClickListener { presenter.changeWatchingStatus(currentModel) }
        act_main_title.text = ""
        act_main_menu.setOnClickListener { finish() }
        act_main_menu.setImageResource(R.mipmap.menu_back)
    }

    override fun onModelLoaded(model: CompanyInnerActModel) {
        act_company_inner_image.loadImageFromUrl(model.imageUrl)
        currentModel = model
        //Glide.with(this).load(model.imageUrl).into(
        if(model.contactInfo != null) {
            act_company_inner_contact_info.visibility = View.VISIBLE
            act_company_inner_contact_info.setContactInfo(model.contactInfo as ContactInfoModel)
        } else act_company_inner_contact_info.visibility = View.GONE

        val movieCount = model.movieItemModel.size
        act_company_inner_movie_count.text = movieCount.toString()

        act_company_inner_movie_list.adapter = CompanyInnerListAdapter(model.movieItemModel)

        act_company_inner_company_name.setTextOrGone(model.companyName)
        act_company_inner_company_desc.setTextOrGone(model.companyDesc)

        initMenuOptionFilter(model.isWatching)
    }

    override fun onFailed(msg: String) {
        makeToast(msg)
    }

    override fun onWatchingStarted(model: CompanyInnerActModel) {
        initMenuOptionFilter(true)
    }

    override fun onWatchingStopped(model: CompanyInnerActModel) {
        initMenuOptionFilter(false)
    }

    override fun onStartWatchFailed() {
        initMenuOptionFilter(false)
    }

    fun initMenuOptionFilter(isWatching: Boolean){
        if(isWatching)
            act_main_option_menu.setColorFilter( Color.parseColor("#ff00ff") )
        else
            act_main_option_menu.colorFilter = null
    }

}
