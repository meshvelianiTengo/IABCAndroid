package iabc.com.voli.iabcandroid.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrl
import iabc.com.voli.iabcandroid.models.MovieItemModel

/**
 * Created by tengo on 12/17/16.
 */
class MovieListItem : RelativeLayout {

    lateinit var image : ImageView
    lateinit var typeTV : TextView
    lateinit var nameTV : TextView

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
        inflater.inflate(R.layout.movie_list_item, this, true)
        initViews()
    }

    private fun initViews(){
        image = findViewById(R.id.movie_list_image) as ImageView
        typeTV = findViewById(R.id.movie_list_content_type) as TextView
        nameTV = findViewById(R.id.movie_list_name) as TextView
    }

    fun setName(name: String){
        nameTV.text = name
    }

    fun setType(type: String){
        typeTV.text = type;
    }

    fun initFromModel(model: MovieItemModel?){
        if(model != null) {
            setName(model.name)
            setType(model.type)
            image.loadImageFromUrl(model.imageUrl)
        }
    }
}