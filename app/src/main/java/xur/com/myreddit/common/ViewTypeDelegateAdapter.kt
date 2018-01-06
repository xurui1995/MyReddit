package xur.com.myreddit.common

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by xur on 2018/1/6.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}