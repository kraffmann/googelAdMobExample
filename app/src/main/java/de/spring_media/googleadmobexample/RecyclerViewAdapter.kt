package de.spring_media.googleadmobexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    lateinit var holderBannerAd: AdView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bannerAd = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_ad_viewholder, parent, false) as AdView
        return ViewHolder(bannerAd)
    }

    override fun getItemCount(): Int {
        return 25
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val adRequest = AdRequest.Builder().build()
        holderBannerAd = holder.bannerAd

        holderBannerAd.adListener = object : AdListener() {
            override fun onAdLoaded() {}
            override fun onAdFailedToLoad(p0: Int) {}
            override fun onAdOpened() {}
            override fun onAdClicked() {}
            override fun onAdLeftApplication() {}
            override fun onAdClosed() {}
        }

        holderBannerAd.loadAd(adRequest)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holderBannerAd.adListener = null
        holderBannerAd.destroy()
    }

    class ViewHolder(val bannerAd: AdView): RecyclerView.ViewHolder(bannerAd)
}
