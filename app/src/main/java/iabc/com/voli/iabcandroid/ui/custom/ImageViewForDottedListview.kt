package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import iabc.com.voli.iabcandroid.R


/**
 * Created by tengo on 12/21/16.
 */
class ImageViewForDottedListview : ImageView{

    var dotStartPoint = 220f
    var dotViewHeight = 220f

    private var dotPadding = 10f
    private var dotRadius = 5f
    private var dotLineWidth = 2f


    constructor(context: Context?) : super(context){ initValues() }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {initValues()}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){ initValues() }

    fun initValues(){
        val r = resources
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, r.displayMetrics)
        dotViewHeight =  resources.getDimension(R.dimen.list_of_event_fr_list_element_height)
        dotStartPoint = dotViewHeight / 2
        dotPadding *= px
        dotRadius *= px

    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(dotStartPoint <= 0 || dotViewHeight <= 0)
            return
        var dotCenterY = dotStartPoint

        val dotCenterX = width / 2 - dotRadius
        while(dotCenterY < height) {

            canvas?.drawCircle(dotCenterX, dotCenterY, dotRadius, getPaintForDot())

            val lineLeft = dotCenterX - dotLineWidth /2
            val lineTop = dotCenterY + dotPadding + dotRadius
            val lineRight = dotCenterX + dotLineWidth /2
            val lineHeight = dotViewHeight - 2* dotRadius - 2* dotPadding
            val lineBottom = lineTop + + lineHeight

            canvas?.drawRect(lineLeft, lineTop,
                    lineRight, lineBottom, getLinePForDot())
            dotCenterY += dotViewHeight
        }

    }


    var circlePaint : Paint? = null
    var linePaintForDot : Paint? = null

    private fun getPaintForDot(): Paint{
        if(circlePaint == null){
            circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
            circlePaint?.color = Color.RED
            circlePaint?.style = Paint.Style.FILL
        }
        return circlePaint as Paint
    }


    private fun getLinePForDot(): Paint{
        if(linePaintForDot == null){
            linePaintForDot = Paint(Paint.ANTI_ALIAS_FLAG)
            linePaintForDot?.setColor(R.color._EBEBEB)
            linePaintForDot?.style = Paint.Style.FILL
        }

        return linePaintForDot as Paint
    }

}