package iabc.com.voli.iabcandroid.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import iabc.com.voli.iabcandroid.R
import iabc.com.voli.iabcandroid.ui.fragments.CompanyListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_main, CompanyListFragment()).commit()
    }
}
