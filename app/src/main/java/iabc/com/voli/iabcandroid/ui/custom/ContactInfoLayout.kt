package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.ContactInfoModel
import kotlinx.android.synthetic.main.contact_info_layout.view.*

/**
 * Created by tengo on 12/18/16.
 */
class ContactInfoLayout : LinearLayout{

    lateinit var titleTV : TextView
    lateinit var locationV : AboutUsNameValuePair
    lateinit var mailV : AboutUsNameValuePair
    lateinit var mobileV : AboutUsNameValuePair

    constructor(context: Context?) : super(context){
        inflaitLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflaitLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflaitLayout()
    }

    fun inflaitLayout(){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.contact_info_layout, this, true)
        initViews();
    }

    fun initViews(){
        titleTV = contact_info_layout_title
        locationV = contact_info_layout_location
        mailV = contact_info_layout_mail
        mobileV = contact_info_layout_mobile
    }

    fun setContactInfo(location: String?, mail: String?, mobile: String?){
        setTextOrHide(location, R.string.location, locationV)
        setTextOrHide(mail, R.string.email, mailV)
        setTextOrHide(mobile, R.string.mobile, mobileV)
    }

    fun setContactInfo(info: ContactInfoModel){
        setContactInfo(info.location, info.email, info.mobile)
    }

    fun setTextOrHide(text: String?, @StringRes title: Int, view: AboutUsNameValuePair){
        if(text == null) view.visibility = View.GONE
        else {
            view.visibility = View.VISIBLE
            view.setNameAndValue(title, text)
        }
    }
}