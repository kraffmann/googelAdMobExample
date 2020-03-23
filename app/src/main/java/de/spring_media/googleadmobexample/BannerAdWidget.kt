package de.spring_media.googleadmobexample

import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import de.welt.widgetadapter.Widget
import kotlinx.android.synthetic.main.banner_ad_viewholder.view.*


class BannerAdWidget: Widget<AdRequest>(R.layout.banner_ad_viewholder) {

    private lateinit var bannerAd: AdView

    override fun onViewCreated(view: View) {
        bannerAd = view.adView
    }

    override fun setData(data: AdRequest) {
        bannerAd.adListener = object : AdListener() {
            override fun onAdLoaded() {}
            override fun onAdFailedToLoad(p0: Int) {}
            override fun onAdOpened() {}
            override fun onAdClicked() {}
            override fun onAdLeftApplication() {}
            override fun onAdClosed() {}
        }

        bannerAd.loadAd(data)
    }
}
