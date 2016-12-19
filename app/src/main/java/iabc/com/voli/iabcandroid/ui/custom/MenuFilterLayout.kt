package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import iabc.com.voli.iabcandroid.R
import kotlinx.android.synthetic.main.menu_filter_layout.view.*



/**
 * Created by tengo on 12/19/16.
 */
class MenuFilterLayout : LinearLayout{

    enum class FilterState{
        OPEN, CLOSED, OPENING, CLOSING
    }

    lateinit var designV : CustomChooseItemLayout
    lateinit var cartoonV : CustomChooseItemLayout
    lateinit var comixV : CustomChooseItemLayout
    lateinit var musicAndSoundV : CustomChooseItemLayout
    lateinit var booksV : CustomChooseItemLayout
    lateinit var containerV: ViewGroup
    lateinit var rootV: ViewGroup

    var state = FilterState.CLOSED

    var callback : MenuFilterCallback? = null

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
        inflater.inflate(R.layout.menu_filter_layout, this, true)
        initViews()

    }

    private fun initViews(){
        rootV = menu_filter_layout_root
        containerV = menu_filter_layout_item_container

        designV = menu_filter_design
        cartoonV = menu_filter_catoon
        comixV = menu_filter_comix
        musicAndSoundV = menu_filter_music_sound
        booksV = menu_filter_books

        designV.setText(R.string.filter_design)
        cartoonV.setText(R.string.filter_cartoon)
        comixV.setText(R.string.filter_comix)
        musicAndSoundV.setText(R.string.filter_music_and_sound)
        booksV.setText(R.string.filter_books)

        designV.setOnClickListener {
            callback?.onItemClicked(0, designV.changeActivation())
        }
        cartoonV.setOnClickListener {
            callback?.onItemClicked(1, cartoonV.changeActivation())
        }
        comixV.setOnClickListener {
            callback?.onItemClicked(2, comixV.changeActivation())
        }
        musicAndSoundV.setOnClickListener {
            callback?.onItemClicked(3, musicAndSoundV.changeActivation())
        }
        booksV.setOnClickListener {
            callback?.onItemClicked(4, booksV.changeActivation())
        }
        designV.setActivation(false)
        cartoonV.setActivation(false)
        comixV.setActivation(false)
        musicAndSoundV.setActivation(false)
        booksV.setActivation(false)

        rootV.setOnClickListener { hide() }
    }

    fun show(){
        slideDownUp(containerV, rootV, true)
    }

    fun hide(){
        slideDownUp(containerV, rootV, false)
    }


    private fun slideDownUp(container: View?, backgroundV: View, open: Boolean ) {
        if(isOpening() ||isClosing()){
            return
        }
        if(open){
            this@MenuFilterLayout.visibility = VISIBLE
        }

        val containerAnimResId = if(open) R.anim.slide_down else R.anim.slide_up
        val backgroundAnimId = if(open) R.anim.fade_in else R.anim.fade_out

        if (container != null) {
            val containerAnimation = AnimationUtils.loadAnimation(container.context, containerAnimResId)
            val backgroundAnimation = AnimationUtils.loadAnimation(backgroundV.context, backgroundAnimId)
            containerAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {

                }

                override fun onAnimationEnd(animation: Animation) {
                    if(!open){
                        this@MenuFilterLayout.visibility = GONE
                        state = FilterState.CLOSED
                    }else{
                        state = FilterState.OPEN
                    }
                    callback?.stateChanged(isOpen())
                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })
            container.startAnimation(containerAnimation)
            backgroundV.startAnimation(backgroundAnimation)

        }
    }

    fun isOpen(): Boolean{
        return state == FilterState.OPEN
    }

    fun isOpening(): Boolean{
        return state == FilterState.OPENING
    }
    fun isClosing(): Boolean{
        return state == FilterState.CLOSING
    }

    interface MenuFilterCallback{
        fun stateChanged(isOpen: Boolean)
        fun onItemClicked(itemId: Int, activated: Boolean)
    }

}