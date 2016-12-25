package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import kotlinx.android.synthetic.main.menu_item.*

/**
 * Created by Zaura on 12/26/2016.
 */
class MenuView : LinearLayout{

    companion object{
        const val ACTIVATED_COLOR_TEXT = R.color._222222
        const val NORMAL_COLOR_TEXT = R.color.black
        const val NORMAL_BACKGROUND = R.color.white
        const val ACTIVATED_BACKGROUND = R.color._F4F4F4
        const val IMAGE_NORMAL_FILTER = R.color.black
        const val IMAGE_ACTIVATED_FILETER = R.color._222222
    }

    lateinit var indicator : ImageView
    lateinit var textV: TextView
    lateinit var imageV: ImageView

    var _selected = false

    constructor(context: Context?) : super(context){
        inflateView(null)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflateView(attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflateView(attrs)
    }

    fun inflateView(attrs: AttributeSet?){
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.menu_item, this, true)
        indicator = findViewById(R.id.menu_item_activation_indicator) as ImageView
        textV = findViewById(R.id.menu_item_text) as TextView
        imageV = findViewById(R.id.menu_item_image) as ImageView
        indicator.visibility = View.INVISIBLE
        if(attrs != null)
            parseAttrs(attrs)
    }

    fun parseAttrs(attrs: AttributeSet){

        val info = context.theme.obtainStyledAttributes(attrs, R.styleable.MenuView, 0, 0)
        try{
            val src = info.getDrawable(R.styleable.MenuView_m_v_icon_src)
            val text = info.getString(R.styleable.MenuView_m_v_text)
            textV.text = text
            imageV.setImageDrawable(src)
        }catch (e: Exception){
            e.printStackTrace()
        }finally {
            info.recycle()
        }
    }

    fun activate(){
        _selected = true
        indicator.visibility = View.VISIBLE
        textV.setTextColor(ACTIVATED_COLOR_TEXT)
        setBackgroundColor(ACTIVATED_BACKGROUND)
        imageV.setColorFilter(IMAGE_ACTIVATED_FILETER)
    }

    fun deactivate(){
        _selected = false
        indicator.visibility = View.INVISIBLE
        textV.setTextColor(NORMAL_COLOR_TEXT)
        setBackgroundColor(NORMAL_BACKGROUND)
        imageV.colorFilter = null
    }

    fun is_Selected(): Boolean{
        return _selected
    }

}
