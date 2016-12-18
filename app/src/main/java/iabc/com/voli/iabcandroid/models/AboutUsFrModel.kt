package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/18/16.
 */
class AboutUsFrModel() : BaseModel(){
    lateinit var textList: List<String>
    lateinit var contactInfo: ContactInfo

    constructor(textList: List<String>, contactInfo: ContactInfo) : this() {
        this.textList = textList
        this.contactInfo = contactInfo
    }


    class ContactInfo{
        val location: String
        val email: String
        val mobile: String

        constructor(location: String, email: String, mobile: String) {
            this.location = location
            this.email = email
            this.mobile = mobile
        }
    }
}