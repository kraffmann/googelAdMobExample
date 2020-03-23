package de.spring_media.googleadmobexample

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import de.welt.widgetadapter.WidgetAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val numOfBanners = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        val linearLayoutManager = LinearLayoutManager(this)
        val items = mutableListOf<AdRequest>()
        val recyclerViewAdapter = CustomWidgetAdapter(LayoutInflater.from(this@MainActivity)).apply {
            (0 until numOfBanners).forEach { _ ->
                addWidget { BannerAdWidget() }
                items.add(AdRequest.Builder().build())
            }
        }
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = recyclerViewAdapter
            recyclerViewAdapter.setItems(items)
        }
    }
}
