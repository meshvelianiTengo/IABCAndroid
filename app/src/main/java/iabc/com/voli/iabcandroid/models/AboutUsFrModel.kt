package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsFrModel() : BaseModel(){
    lateinit var textList: List<String>
    lateinit var contactInfo: ContactInfoModel

    constructor(textList: List<String>, contactInfo: ContactInfoModel) : this() {
        this.textList = textList
        this.contactInfo = contactInfo
    }
}