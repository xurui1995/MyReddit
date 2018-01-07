package xur.com.myreddit.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_fragment.*
import xur.com.myreddit.R
import xur.com.myreddit.common.RedditNewsItem
import xur.com.myreddit.common.extensions.inflate
import xur.com.myreddit.features.news.adapter.NewsAdapter

/**
 * Created by xur on 2018/1/4.
 */
class NewsFragment : Fragment() {
    //private var newsList: RecyclerView? = null
    private val newsList by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       // val view = container?.inflate(R.layout.news_fragment)
/*        newsList = view?.findViewById<RecyclerView>(R.id.news_list) as RecyclerView
        newsList?.setHasFixedSize(true)
        newsList?.layoutManager = LinearLayoutManager(context)*/

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
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
            (news_list.adapter as NewsAdapter).addNews(news)
        }

    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

}