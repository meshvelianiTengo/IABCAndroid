package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/24/16.
 */
class CompanyInnerActModel() : BaseModel(){
    var imageUrl: String? = null
    var contactInfo: ContactInfoModel? = null
    lateinit var movieItemModel: List<MovieItemModel>

    constructor(imageUrl: String?, contactInfo: ContactInfoModel?, movieItemModel: List<MovieItemModel>) : this() {
        this.imageUrl = imageUrl
        this.contactInfo = contactInfo
        this.movieItemModel = movieItemModel
    }
}