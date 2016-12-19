package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.graphics.Color
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import kotlinx.android.synthetic.main.custom_choose_item_layout.view.*

/**
 * Created by tengo on 12/19/16.
 */
class CustomChooseItemLayout : LinearLayout {

    lateinit var textV : TextView
    lateinit var rootV : View
    var isLayoutActivated  = false

    constructor(context: Context?) : super(context){
        inflateLayout();
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflateLayout();
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflateLayout();
    }

    fun inflateLayout(){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_choose_item_layout, this, true)
        initViews()
    }

    private fun initViews() {
        textV = custom_choose_item_layout_text;
        rootV = custom_choose_item_layout_root
    }

    private fun activate(){
        isLayoutActivated = true
        textV.setTextColor(Color.parseColor("#ffffff"))
        rootV.setBackgroundResource(R.drawable.custom_choose_item_layout_background_act)
    }
    private fun deactivate(){
        isLayoutActivated = false
        rootV.setBackgroundResource(R.drawable.custom_choose_item_layout_background_normal)
        textV.setTextColor(R.color._757575)
    }

    fun setActivation(activate: Boolean){
        if (activate) activate() else deactivate()
    }

    fun changeActivation(): Boolean{
        setActivation(!isLayoutActivated)
        return isLayoutActivated
    }

    fun setText(text: String){
        textV.text = text
    }
    fun setText(@StringRes text: Int){
        textV.setText(text)
    }
}