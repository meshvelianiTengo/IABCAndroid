package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlaceFrModel() : BaseModel(){
    var imageUrl = ""
    var type = ""
    var name = ""

    constructor(imageUrl: String, type: String, name: String) : this() {
        this.imageUrl = imageUrl
        this.type = type
        this.name = name
    }
}