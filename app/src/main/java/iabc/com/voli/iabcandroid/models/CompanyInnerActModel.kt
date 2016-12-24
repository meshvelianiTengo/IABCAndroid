package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/24/16.
 */
class CompanyInnerActModel() : BaseModel(){
    var companyId: Int = -1;
    var imageUrl: String? = null
    var contactInfo: ContactInfoModel? = null
    var companyName: String? = null
    var companyDesc: String? = null
    lateinit var movieItemModel: List<MovieItemModel>
    var isWatching = false

    constructor(companyId: Int, imageUrl: String?, contactInfo: ContactInfoModel?, companyName: String?, companyDesc: String?, movieItemModel: List<MovieItemModel>, isWatching :Boolean = false) : this() {
        this.companyId = companyId
        this.imageUrl = imageUrl
        this.contactInfo = contactInfo
        this.companyName = companyName
        this.companyDesc = companyDesc
        this.movieItemModel = movieItemModel
        this.isWatching = false
    }

}