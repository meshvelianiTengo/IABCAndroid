package iabc.com.voli.iabcandroid.models

import java.io.Serializable

/**
 * Created by tengo on 12/22/16.
 */
class EventDescription() : Serializable{
    constructor(evName: String, evCategory: String, evLocation: String) : this(){
        this.evName = evName
        this.evCategory = evCategory
        this.evLocation = evLocation
    }

    var evName = ""
    var evCategory = ""
    var evLocation = ""
}
