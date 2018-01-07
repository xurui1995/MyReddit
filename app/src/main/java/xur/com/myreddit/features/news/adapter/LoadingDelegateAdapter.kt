package xur.com.myreddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import xur.com.myreddit.R
import xur.com.myreddit.common.ViewType
import xur.com.myreddit.common.ViewTypeDelegateAdapter
import xur.com.myreddit.common.extensions.inflate

/**
 * Created by xur on 2018/1/6.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}