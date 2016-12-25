package iabc.com.voli.iabcandroid.models

/**
 * Created by tengo on 12/25/16.
 */
class FAQModel() : BaseModel() {
    lateinit var question: String
    lateinit var answear: String

    constructor(question: String, answear: String) : this() {
        this.question = question
        this.answear = answear
    }
}