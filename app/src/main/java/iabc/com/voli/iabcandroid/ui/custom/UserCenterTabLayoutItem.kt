package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R

/**
 * Created by tengo on 12/25/16.
 */
class UserCenterTabLayoutItem : LinearLayout{

    lateinit var imageV : ImageView
    lateinit var textV : TextView

    constructor(context: Context?) : super(context){
        inflateLayout(null);
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflateLayout(attrs);
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflateLayout(attrs);
    }

    private fun inflateLayout(attrs: AttributeSet?) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.user_center_text_with_icon_layout, this, true)
        initViews()
        parseAttrs(attrs)
    }

    private fun parseAttrs(attrs: AttributeSet?) {
        if(attrs != null) {
            val info = context.theme.obtainStyledAttributes(attrs, R.styleable.UserCenterTabLayoutItem, 0, 0)
            try{
                val src = info.getDrawable(R.styleable.UserCenterTabLayoutItem_u_c_t_icon_src)
                val text = info.getString(R.styleable.UserCenterTabLayoutItem_u_c_t_text)
                textV.text = text
                imageV.setImageDrawable(src)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                info.recycle()
            }
        }
    }

    private fun initViews() {
        imageV = findViewById(R.id.user_center_text_with_icon_layout_icon) as ImageView
        textV = findViewById(R.id.user_center_text_with_icon_layout_text) as TextView
    }

}