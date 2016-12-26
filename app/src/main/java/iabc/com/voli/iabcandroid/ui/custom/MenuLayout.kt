package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.info.IABCUser
import iabc.com.voli.iabcandroid.loadRoundImageFromUrl
import iabc.com.voli.iabcandroid.models.MenuItemModel

/**
 * Created by tengo on 12/26/16.
 */
class MenuLayout : LinearLayout{

    lateinit private var items: List<MenuItemModel>
    lateinit private var menuHeaderView: View

    var activatedView: MenuView? = null

    lateinit private var userLoginImage: ImageView
    lateinit private var  userLoginText: TextView
    val viewList: MutableList<MenuView> = mutableListOf()

    var menuActionCallback : OnMenuAction? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun initContent(itemList: List<MenuItemModel>){
        items = itemList;
        addMenuItems()
    }

    private fun addMenuItems(){
        addHeader()
        viewList.clear()
        for((i, item) in items.withIndex()){
            viewList.add(addMenuItem(item, i))
        }
    }

    private fun addHeader() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        menuHeaderView = inflater.inflate(R.layout.nav_header_main, null)
        addView(menuHeaderView)
        initHeaderView()
    }

    private fun addMenuItem(item: MenuItemModel, index: Int): MenuView{
        val v = MenuView(context);
        v.setContent(item)
        v.id = index
        addView(v)
        v.setOnClickListener { onItemClicked(v) }
        return v
    }

    private fun onItemClicked(v: MenuView) {
        activatedView?.deactivate();
        activatedView = v;
        activatedView?.activate()
        menuActionCallback?.onItemChosen(v.id)
    }


    fun initHeaderView(){
        userLoginImage = menuHeaderView.findViewById(R.id.menu_header_user_image) as ImageView
        userLoginText = menuHeaderView.findViewById(R.id.menu_header_user_text) as TextView
        menuHeaderView.findViewById(R.id.menu_header_user_close).setOnClickListener {
            menuActionCallback?.onMenuClose()
        }
        userLoginImage.setOnClickListener {
            menuActionCallback?.onLoginRequested()
        }

    }

    fun fillHeader(user: IABCUser){
        if(user.image == null)
            loadDefaultImageForUser()
        else {
            userLoginImage.setPadding(0, 0, 0, 0)
            userLoginImage.loadRoundImageFromUrl(user.image as String)
        }
        userLoginText.text = user.name
    }

    fun fillHeaderForNoUser(){
        loadDefaultImageForUser()
        userLoginText.setText(R.string.login)
    }

    fun loadDefaultImageForUser(){
        val padding = userLoginText.width/4
        userLoginImage.setPadding(padding, padding, padding, padding)
        userLoginImage.setImageResource(R.mipmap.use_login_def_image)
        userLoginImage.setBackgroundResource(R.drawable.menu_user_login_def_background)
    }


    interface OnMenuAction{
        fun onItemChosen(index: Int)
        fun onMenuClose()
        fun onLoginRequested()
    }
}