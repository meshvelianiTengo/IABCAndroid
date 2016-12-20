package iabc.com.voli.iabcandroid.interactors

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.ItemInnerFrPICalback
import iabc.com.voli.iabcandroid.models.ItemInnerFrModel

/**
 * Created by tengo on 12/20/16.
 */
class ItemInnerFrInteractor {
    fun startGettingItemInfo(itemId: String, callback: ItemInnerFrPICalback){
        callback.onSuccess(ItemInnerFrModel("name", "genre", 4.0, "1999", "director", "writer", (1..4).map { "actor " +it },
                "https://www.youtube.com/watch?v=QVj7UuLOATo&list=PLkZF4lxVeBcGIJ8LKRFmgKa4XYjZ6OzQx&index=21",
                "desc name", "description", HomeFragmentInteractor.DEF_IMAGE_URL,HomeFragmentInteractor.DEF_IMAGE_URL, "author" ))
    }
}