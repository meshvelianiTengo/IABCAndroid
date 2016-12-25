package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import iabc.com.voli.iabcandroid.R


/**
 * Created by tengo on 12/12/16.
 */
class CTextView : TextView{

    companion object{
        var fullTextSize = 12
    }

    var plusTextSize = 0
    var xTextSize :Float = 1.toFloat()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initAttrs(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initAttrs(attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes){
        initAttrs(attrs)
    }

    private fun initAttrs(attrs: AttributeSet?){
        if(attrs != null){
            val texts = context.theme.obtainStyledAttributes(attrs, R.styleable.CtextViewStyle, 0, 0)
            try {
                val font = texts.getInt(R.styleable.CtextViewStyle_font_name, -1)
                setFont(font)
                plusTextSize = texts.getInt(R.styleable.CtextViewStyle_plusTextSize, 0)
                xTextSize = texts.getFloat(R.styleable.CtextViewStyle_xTextSize, 1f)
            } catch (e: Exception) {
                e.printStackTrace()
            }finally {
                texts.recycle()
            }

            initTextSize()
        }
    }

    fun initTextSize(){
        textSize = (fullTextSize + plusTextSize) * xTextSize
    }

    fun setFont(fontId : Int){

    }



}