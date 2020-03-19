package de.spring_media.googleadmobexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        val linearLayoutManager = LinearLayoutManager(this)
        val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = recyclerViewAdapter
        }
    }
}
