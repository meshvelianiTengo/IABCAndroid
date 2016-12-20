package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/20/16.
 */
class ItemInnerFrModel() : BaseModel() {
    lateinit var name : String
    lateinit var genre: String
    var stars = 0.0
    lateinit var releaseYear: String
    lateinit var director: String
    lateinit var writer: String
    lateinit var actors: List<String>
    lateinit var trailerLink: String

    lateinit var descName: String
    lateinit var desc: String

    lateinit var imageLink: String
    lateinit var authorImage: String
    lateinit var author: String

    constructor(name: String, genre: String, stars: Double, releaseYear: String, director: String, writer: String, actors: List<String>, trailerLink: String, descName: String, desc: String, imageLink: String, authorImage: String, author: String) : this() {
        this.name = name
        this.genre = genre
        this.stars = stars
        this.releaseYear = releaseYear
        this.director = director
        this.writer = writer
        this.actors = actors
        this.trailerLink = trailerLink
        this.descName = descName
        this.desc = desc
        this.imageLink = imageLink
        this.authorImage = authorImage
        this.author = author
    }
}