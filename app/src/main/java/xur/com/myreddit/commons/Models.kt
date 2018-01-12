package xur.com.myreddit.commons

/**
 * Created by xur on 2018/1/6.
 */
data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>)

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}