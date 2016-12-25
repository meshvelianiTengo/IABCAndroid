package iabc.com.voli.iabcandroid.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.loadImageFromUrl
import iabc.com.voli.iabcandroid.makeToast
import iabc.com.voli.iabcandroid.models.EventInnerModel
import iabc.com.voli.iabcandroid.presenter.EventInnerPresenter
import iabc.com.voli.iabcandroid.view.EventInnerView
import kotlinx.android.synthetic.main.activity_event_inner.*
import kotlinx.android.synthetic.main.fr_event_inner.*

class EventInnerActivity : AppCompatActivity(), EventInnerView {

    val presenter = EventInnerPresenter(this)
    var model : EventInnerModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_inner)
        act_event_inner_back.setOnClickListener { onBackPressed() }
        act_event_inner_join.setOnClickListener { presenter.changeJoinStatus(model) }
        presenter.startGettinInfo("123")
    }

    override fun onSuccess(model: EventInnerModel) {
        this.model = model
        fr_event_inner_title.text = model.name
        fr_event_inner_location.text = model.location
        fr_event_inner_end_time.text = model.endTime
        fr_event_inner_start_time.text = model.startTime
        fr_event_inner_image.loadImageFromUrl(model.imageUrl, R.mipmap.into_image)
        fr_event_inner_bottom_desc.text = model.desc
        changeChoinStatus(model.isJoined)
    }

    override fun onError(msg: String) {
        makeToast(msg)
    }

    override fun onEventJoined(model: EventInnerModel) {
        this.model = model
        act_event_inner_join.setTextColor(R.color.black)
        act_event_inner_join.setText(R.string.act_event_inner_menu_joined)
        changeChoinStatus(model.isJoined)
    }

    override fun onEventUnjoined(model: EventInnerModel) {
        this.model = model
        changeChoinStatus(model.isJoined)
    }

    override fun onJoinFailed(msg: String) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun changeChoinStatus(isJoined: Boolean) {
        if(isJoined) {
            act_event_inner_join.setTextColor(R.color.black)
            act_event_inner_join.setText(R.string.act_event_inner_menu_joined)
        }else{
            act_event_inner_join.setTextColor(R.color._727272)
            act_event_inner_join.setText(R.string.act_event_inner_menu_join)
        }
    }
}
