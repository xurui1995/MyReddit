package xur.com.myreddit.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import xur.com.myreddit.R
import xur.com.myreddit.common.RxBaseFragment
import xur.com.myreddit.common.extensions.inflate
import xur.com.myreddit.features.news.adapter.NewsAdapter

/**
 * Created by xur on 2018/1/4.
 */
class NewsFragment : RxBaseFragment() {
    private val newsManager by lazy { NewsManager() }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }

    }

    private fun requestNews() {
        val subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {retrievedNews -> (news_list.adapter as NewsAdapter).addNews(retrievedNews)},
                        {e -> Snackbar.make(news_list, e.message ?: "",Snackbar.LENGTH_LONG).show()}
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

}