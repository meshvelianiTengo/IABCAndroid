package iabc.com.voli.iabcandroid.models

import java.util.*

/**
 * Created by tengo on 12/20/16.
 */
class EventListFrModel() : BaseModel() {
    var date = ""
    var eventList = ArrayList<EventDescription>()

    constructor(date: String, eventList: ArrayList<EventDescription>) : this() {
        this.date = date
        this.eventList = eventList
    }





    fun getDateFormattedForRecycler(): String{
        return date
    }
}