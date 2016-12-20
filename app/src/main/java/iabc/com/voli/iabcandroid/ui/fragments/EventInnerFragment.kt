package iabc.com.voli.iabcandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.EventInnerFrModel
import iabc.com.voli.iabcandroid.presenter.EventInnerPresenter
import iabc.com.voli.iabcandroid.view.EventInnerFrView
import kotlinx.android.synthetic.main.fr_event_inner.*

/**
 * Created by tengo on 12/20/16.
 */
class EventInnerFragment : BaseFragment(), EventInnerFrView{

    val presenter = EventInnerPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_event_inner, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.startGettinInfo("123")
    }

    override fun onSuccess(model: EventInnerFrModel) {
        fr_event_inner_title.text = model.name
        fr_event_inner_location.text = model.location
        fr_event_inner_end_time.text = model.endTime
        fr_event_inner_start_time.text = model.startTime

        Glide.with(context).load(model.imageUrl).placeholder(R.mipmap.into_image).into(fr_event_inner_image)

    }

    override fun onError(msg: String) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}