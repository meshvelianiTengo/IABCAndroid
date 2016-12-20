package iabc.com.voli.iabcandroid.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.ItemInnerFrModel
import iabc.com.voli.iabcandroid.presenter.ItemInnerFrPresenter
import iabc.com.voli.iabcandroid.view.ItemInnerFrView
import kotlinx.android.synthetic.main.fragment_item_inner.*


/**
 * Created by tengo on 12/20/16.
 */
class ItemInnerFragment : BaseFragment(), ItemInnerFrView{

    val presenter = ItemInnerFrPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_item_inner, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettingInfo("123")

    }


    override fun onModelLoaded(model: ItemInnerFrModel) {
        Glide.with(context).load(model.imageLink).placeholder(R.mipmap.into_image).into(fr_item_inner_film_image)
        fr_item_inner_watch_trailer.setOnClickListener { loadTrailer(model.trailerLink) }

        fr_item_inner_title.text = model.name
        fr_item_inner_genre.text = model.genre
        loadStars(fr_item_inner_stars, model.stars)
        loadNameValue(fr_item_inner_nvpair_release_date, R.string.fr_item_inner_release_date, model.releaseYear)

        loadNameValue(fr_item_inner_nvpair_release_director, R.string.fr_item_inner_release_director, model.director)

        loadNameValue(fr_item_inner_nvpair_release_writer, R.string.fr_item_inner_release_writer, model.writer)

        loadNameValue(fr_item_inner_nvpair_release_actors, R.string.fr_item_inner_release_actors, getActorList(model.actors))

        fr_item_inner_desc_name.text = model.descName
        fr_item_inner_desc.text = model.desc
    }

    private fun loadStars(parent: LinearLayout, stars: Double){

    }

    private fun getActorList(list: List<String>): String{
        var ret = ""
        for((i, value) in list.withIndex()){
            ret += value
            if(i < list.size-1){
                ret+= "\n"
            }
        }
        return ret
    }

    private fun loadTrailer(link: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }


    private fun loadNameValue(parent: View, @StringRes name: Int, value: String){
        (parent.findViewById(R.id.fr_item_inner_name_value_pair_name) as TextView).setText(name)
        (parent.findViewById(R.id.fr_item_inner_name_value_pair_value) as TextView).text = value

    }

    override fun onError(msg: String) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}