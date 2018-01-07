package xur.com.myreddit.common

/**
 * Created by xur on 2018/1/6.
 */
data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstans.NEWS
}