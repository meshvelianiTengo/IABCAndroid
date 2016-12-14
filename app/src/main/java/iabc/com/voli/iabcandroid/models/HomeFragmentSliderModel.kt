package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/13/16.
 */
class HomeFragmentSliderModel() : BaseModel() {
    var text = ""
    var image = ""

    constructor(text: String, image: String) : this() {
        this.text = text
        this.image = image
    }
}