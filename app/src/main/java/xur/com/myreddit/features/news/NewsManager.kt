package xur.com.myreddit.features.news

import rx.Observable
import xur.com.myreddit.common.RedditNewsItem


/**
 * Created by xur on 2018/1/7.
 */
class NewsManager() {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}