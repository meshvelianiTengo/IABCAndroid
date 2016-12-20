package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerFrModel() : BaseModel() {
    lateinit var imageUrl: String
    lateinit var name: String
    lateinit var location: String
    lateinit var startTime: String
    lateinit var endTime: String
    lateinit var date: String

    constructor(imageUrl: String, name: String, location: String, startTime: String, entTime: String, date: String) : this(){
        this.imageUrl = imageUrl
        this.name = name
        this.location = location
        this.startTime = startTime
        this.endTime = entTime
        this.date = date
    }
}