package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/24/16.
 */
class ContactInfoModel {
    val location: String
    val email: String
    val mobile: String

    constructor(location: String, email: String, mobile: String) {
        this.location = location
        this.email = email
        this.mobile = mobile
    }
}