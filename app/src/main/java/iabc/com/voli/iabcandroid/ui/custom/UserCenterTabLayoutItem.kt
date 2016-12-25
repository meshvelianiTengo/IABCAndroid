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
        inflateLayout();
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inflateLayout();
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        inflateLayout();
    }

    private fun inflateLayout() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.user_center_text_with_icon_layout, this, true)
        initViews()
    }

    private fun initViews() {
        imageV = findViewById(R.id.user_center_text_with_icon_layout_icon) as ImageView
        textV = findViewById(R.id.user_center_text_with_icon_layout_text) as TextView
    }

}