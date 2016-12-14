package iabc.com.voli.iabcandroid.interactor_presenter_callbacks

import iabc.com.voli.iabcandroid.models.HomeFragmentSliderModel

/**
 * Created by tengo on 12/14/16.
 */
interface HomeFragmentInteractorDescriptionCallback : BasePICallback {
    fun onDescriptionDownloaded(list: List<HomeFragmentSliderModel>)
    fun onDescriptionError(error: String)
}