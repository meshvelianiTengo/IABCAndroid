package iabc.com.voli.iabcandroid.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.MovieItemModel
import iabc.com.voli.iabcandroid.ui.custom.MovieListItem

/**
 * Created by tengo on 12/24/16.
 */
class CompanyInnerListAdapter(private val movieList: List<MovieItemModel>) : RecyclerView.Adapter<CompanyInnerListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.movieItem?.initFromModel(movieList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.act_company_inner_list_item, parent, false)

        // Return a new holder instance
        val viewHolder = ViewHolder(contactView)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return movieList.size
    }



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val movieItem: MovieListItem
        init {
            movieItem = view.findViewById(R.id.act_company_inner_list_movie_item) as MovieListItem
        }
    }
}