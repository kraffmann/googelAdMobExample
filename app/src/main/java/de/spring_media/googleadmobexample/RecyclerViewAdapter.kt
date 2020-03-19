package de.spring_media.googleadmobexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

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
        val bannerAd = holder.bannerAd
        bannerAd.loadAd(adRequest)
    }

    class ViewHolder(val bannerAd: AdView): RecyclerView.ViewHolder(bannerAd)
}
