package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/13/16.
 */
class HomeFragmentMovieModel() :BaseModel() {
    var image = ""
    var title = ""

    constructor(image: String, title: String) : this() {
        this.image = image
        this.title = title
    }
}