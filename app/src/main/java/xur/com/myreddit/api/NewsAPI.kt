package xur.com.myreddit.api

import retrofit2.Call

/**
 * Created by xur on 2018/1/16.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}