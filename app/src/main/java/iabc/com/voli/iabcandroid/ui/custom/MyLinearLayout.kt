package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

import iabc.com.voli.iabcandroid.ui.adapters.HomePageAdapter

/**
 * Created by tengo on 12/13/16.
 */

class MyLinearLayout : LinearLayout {
    private var scale = HomePageAdapter.BIG_SCALE

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context) : super(context) {
    }

    fun setScaleBoth(scale: Float) {
        this.scale = scale
        this.invalidate()    // If you want to see the scale every time you set
        // scale you need to have this line here,
        // invalidate() function will call onDraw(Canvas)
        // to redraw the view for you
    }

    override fun onDraw(canvas: Canvas) {
        // The main mechanism to display scale animation, you can customize it
        // as your needs
        val w = this.width
        val h = this.height
        canvas.scale(scale, scale, (w / 2).toFloat(), (h / 2).toFloat())

        super.onDraw(canvas)
    }
}