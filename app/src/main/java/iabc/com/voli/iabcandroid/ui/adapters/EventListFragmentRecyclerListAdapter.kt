package iabc.com.voli.iabcandroid.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventListFrModel
import iabc.com.voli.iabcandroid.ui.custom.CustomChooseItemLayout


/**
 * Created by tengo on 12/20/16.
 */
class EventListFragmentRecyclerListAdapter(private val eventList: List<EventListFrModel>, private var activatedPosition: Int) : RecyclerView.Adapter<EventListFragmentRecyclerListAdapter.ViewHolder>(){

    private var activatedViewHolder : ViewHolder? = null
    var itemChosenListener: OnListItemChosen? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.getContext()
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.event_list_fr_top_adapter, parent, false)

        // Return a new holder instance
        val viewHolder = ViewHolder(contactView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.text?.setText(eventList[position].getDateFormattedForRecycler())
        holder?.currentPosition = position
        if(position == activatedPosition && holder != null) {
            activate(holder)
        } else {
            holder?.text?.setActivation(false)
        }

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


    private fun activate(newHolder: ViewHolder) {
        activatedViewHolder?.text?.setActivation(false)
        newHolder.text.setActivation(true)
        activatedViewHolder = newHolder
        activatedPosition = newHolder.currentPosition
        if (newHolder.currentPosition > -1 && newHolder.currentPosition < eventList.size)
            itemChosenListener?.onItemChosen(eventList[newHolder.currentPosition], newHolder.currentPosition)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var currentPosition = -1
        val text: CustomChooseItemLayout
        init {
            text = view.findViewById(R.id.event_list_fr_top_adapter_text) as CustomChooseItemLayout
            text.setOnClickListener { activate(this) }
        }
    }


    interface OnListItemChosen{
        fun onItemChosen(item: EventListFrModel, position: Int)
    }

}