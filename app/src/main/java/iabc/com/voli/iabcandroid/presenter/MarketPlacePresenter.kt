package iabc.com.voli.iabcandroid.presenter

import iabc.com.voli.iabcandroid.interactor_presenter_callbacks.MarketPlacePresenterInteractorCallback
import iabc.com.voli.iabcandroid.interactors.MarketPlaceInteractor
import iabc.com.voli.iabcandroid.models.MovieItemModel
import iabc.com.voli.iabcandroid.view.MarketPlaceFrView

/**
 * Created by tengo on 12/17/16.
 */
class MarketPlacePresenter(private val view: MarketPlaceFrView) : BasePresenter(), MarketPlacePresenterInteractorCallback{
    val interactor : MarketPlaceInteractor
    init {
        interactor = MarketPlaceInteractor()
    }

    fun startGettingInfo(list: List<Boolean>){
        interactor.startGettingInfo(list, this)
    }

    fun startGettingFavourites(){
        interactor.startGettingFavouritesList()
    }

    override fun onContentDowloaded(list: List<MovieItemModel>) {
        view.onContentDowloaded(list)
    }

    override fun onContentError(msg: String) {
        view.onContentError(msg)
    }
}