package example.android.com.adancewithdagger.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.android.com.adancewithdagger.R
import example.android.com.adancewithdagger.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
