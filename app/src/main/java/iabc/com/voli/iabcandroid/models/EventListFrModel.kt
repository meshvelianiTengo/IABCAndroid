package iabc.com.voli.iabcandroid.models

import java.util.*

/**
 * Created by tengo on 12/20/16.
 */
class EventListFrModel() : BaseModel() {
    var date = ""
    var eventList : List<EventDescription> = ArrayList<EventDescription>()

    constructor(date: String, eventList: List<EventDescription>) : this() {
        this.date = date
        this.eventList = eventList
    }

    class EventDescription(){
        var evName = ""
        var evCategory = ""
        var evLocation = ""
    }




    fun getDateFormattedForRecycler(): String{
        return date
    }
}