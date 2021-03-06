package iabc.com.voli.iabcandroid.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.animation.AnimationUtils
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.models.IntroActivityModel
import iabc.com.voli.iabcandroid.presenter.IntroActivityPresenter
import iabc.com.voli.iabcandroid.ui.adapters.IntroActivityPagerAdapter
import iabc.com.voli.iabcandroid.ui.custom.CTextView
import iabc.com.voli.iabcandroid.view.IntroActivityView
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity() , IntroActivityView{

    val presenter : IntroActivityPresenter

    init {
        presenter = IntroActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignTextSize(this)
        presenter.checkFirstLaunch()
    }

    fun assignTextSize(activity: Activity) {
        val display = activity.windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = activity.resources.displayMetrics.density
        val dpHeight = outMetrics.heightPixels / density
        val dpWidth = outMetrics.widthPixels / density

        var spHelpHeight = Math.min(dpWidth, dpHeight).toInt()
        spHelpHeight = spHelpHeight - 300
        val spPlusForResolution = spHelpHeight / 100
        CTextView.fullTextSize = 14 + spPlusForResolution
    }


    override fun onFirstLaunch(list: List<IntroActivityModel> ) {
        setTheme(R.style.AppTheme_NoActionBar)
        setContentView(R.layout.activity_intro)
        act_intro_pager.adapter = IntroActivityPagerAdapter(this, list)
        act_intro_tablayout.setupWithViewPager(act_intro_pager, true)

        act_intro_skip.setOnClickListener { onPushMain() }

        val transAnim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim);

        act_intro_logo.startAnimation(transAnim)
    }

    override fun onPushMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
