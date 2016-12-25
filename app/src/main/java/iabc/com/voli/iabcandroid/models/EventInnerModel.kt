package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerModel() : BaseModel() {
    lateinit var imageUrl: String
    lateinit var name: String
    lateinit var location: String
    lateinit var startTime: String
    lateinit var endTime: String
    lateinit var date: String
    lateinit var desc: String
    var isJoined = false

    constructor(imageUrl: String, name: String, location: String, startTime: String, entTime: String, date: String, isJoined: Boolean = false, desc: String) : this(){
        this.imageUrl = imageUrl
        this.name = name
        this.location = location
        this.startTime = startTime
        this.endTime = entTime
        this.date = date
        this.isJoined = isJoined
        this.desc = desc
    }
}