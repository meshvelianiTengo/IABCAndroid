package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/13/16.
 */
class HomeFragmentSliderModel() : BaseModel() {
    var text = ""

    constructor(text: String) : this() {
        this.text = text
    }
}