package example.android.com.adancewithdagger.view.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import example.android.com.adancewithdagger.R
import example.android.com.adancewithdagger.view.fragment.MainFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }

}
