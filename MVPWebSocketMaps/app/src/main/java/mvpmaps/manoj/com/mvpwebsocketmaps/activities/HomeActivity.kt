package mvpmaps.manoj.com.mvpwebsocketmaps.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import mvpmaps.manoj.com.mvpwebsocketmaps.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var linearLayout:LinearLayout = findViewById(R.id.fragment)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val homeFragment = HomeFragment();

        fragmentTransaction.add(linearLayout.id ,homeFragment, HomeFragment.TAG)
        fragmentTransaction.commit()

    }
}
