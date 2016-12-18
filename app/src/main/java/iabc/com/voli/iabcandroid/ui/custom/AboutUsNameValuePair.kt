package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import kotlinx.android.synthetic.main.about_us_name_value_pair.view.*

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsNameValuePair : LinearLayout{

    lateinit var nameTV: TextView
    lateinit var valueTV: TextView

    constructor(context: Context?) : super(context){
        inflaytLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflaytLayout()

    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflaytLayout()
    }

    fun inflaytLayout(){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.about_us_name_value_pair, this, true)
        initViews()
    }

    fun initViews(){
        nameTV = about_us_name_value_name
        valueTV = about_us_name_value_value
    }

    fun setName(name: String){
        nameTV.text = name
    }

    fun setValue(value: String){
        valueTV.text = value
    }

    fun setNameAndValue(name: String, value: String){
        setName(name)
        setValue(value)
    }
    fun setNameAndValue(@StringRes name: Int, value: String){
        setName(name)
        setValue(value)
    }

    fun setName(@StringRes name: Int){
        nameTV.setText(name)
    }
    fun setValue(@StringRes value: Int){
        valueTV.setText(value)
    }
}