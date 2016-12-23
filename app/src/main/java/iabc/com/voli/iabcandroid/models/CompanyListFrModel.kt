package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/23/16.
 */
class CompanyListFrModel() : BaseModel(){
    lateinit var name: String
    lateinit var imageUrl : String

    constructor(name: String, imageUrl: String) : this() {
        this.name = name
        this.imageUrl = imageUrl
    }
}