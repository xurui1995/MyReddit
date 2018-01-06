package xur.com.myreddit.features.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import xur.com.myreddit.common.AdapterConstans
import xur.com.myreddit.common.ViewType
import xur.com.myreddit.common.ViewTypeDelegateAdapter

/**
 * Created by xur on 2018/1/6.
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstans.LOADING

    }

    init {
        delegateAdapters.put(AdapterConstans.LOADING, LoadingDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items[position].getViewType()
    }
}