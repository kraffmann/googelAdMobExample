package de.spring_media.googleadmobexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var bannerAd: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        bannerAd = adView

        bannerAd.adListener = object : AdListener() {
            override fun onAdLoaded() {}
            override fun onAdFailedToLoad(p0: Int) {}
            override fun onAdOpened() {}
            override fun onAdClicked() {}
            override fun onAdLeftApplication() {}
            override fun onAdClosed() {}
        }

        val adRequest = AdRequest.Builder().build()
        bannerAd.loadAd(adRequest)
    }

    override fun onPause() {
        bannerAd.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        bannerAd.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        bannerAd.adListener = null
        bannerAd.destroy()
    }
}
