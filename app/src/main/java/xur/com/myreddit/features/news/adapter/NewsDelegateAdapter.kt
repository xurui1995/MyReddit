package xur.com.myreddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*
import xur.com.myreddit.R
import xur.com.myreddit.commons.RedditNewsItem
import xur.com.myreddit.commons.ViewType
import xur.com.myreddit.commons.ViewTypeDelegateAdapter
import xur.com.myreddit.commons.extensions.getFriendlyTime
import xur.com.myreddit.commons.extensions.inflate
import xur.com.myreddit.commons.extensions.loadImg

/**
 * Created by xur on 2018/1/6.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }

}