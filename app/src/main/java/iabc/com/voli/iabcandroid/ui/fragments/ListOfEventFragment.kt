package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventDescription
import java.util.*

/**
 * Created by tengo on 12/21/16.
 */
class ListOfEventFragment : BaseFragment(){

    companion object{
        const val ITEM_LIST_BUNDLE = "item_list_bundle_name"

        fun newInstanse(args: ArrayList<EventDescription>) : ListOfEventFragment{
            val fr = ListOfEventFragment()
            val bundle = Bundle()
            bundle.putSerializable(ITEM_LIST_BUNDLE, args);
            fr.arguments = bundle
            return fr;
        }
    }

    lateinit var listLayout : LinearLayout

    lateinit var itemList : ArrayList<EventDescription>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.list_of_event_fragment, container, false)
        itemList = arguments.getSerializable(ITEM_LIST_BUNDLE) as ArrayList<EventDescription>
//        itemList = (1..7).map { EventListFrModel.EventDescription("name: " + it, "ev category " +it, "ev location " + it) } as ArrayList<EventListFrModel.EventDescription>
        listLayout = view?.findViewById(R.id.fr_list_of_event_layout) as LinearLayout
        if(inflater != null) {
            initLayout(inflater)
        }

        return view
    }

    fun initLayout(inflater: LayoutInflater){
        val viewHeight=  (resources.getDimension(R.dimen.list_of_event_fr_list_element_height)).toInt()
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, viewHeight)
        for(item in itemList){
            val infView = inflater.inflate(R.layout.list_of_event_fr_list_element, null)
            infView.layoutParams = layoutParams
            (infView.findViewById(R.id.list_of_event_fr_list_element_title) as TextView).text = item.evName
            (infView.findViewById(R.id.list_of_event_fr_list_element_category_location) as TextView).text = item.evCategory + " / " + item.evLocation
            listLayout.addView(infView)
        }
    }
}