package xur.com.myreddit.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xur.com.myreddit.R
import xur.com.myreddit.common.inflate

/**
 * Created by xur on 2018/1/4.
 */
class NewsFragment : Fragment() {
    private var newsList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.news_fragment)
        newsList = view?.findViewById<RecyclerView>(R.id.news_list) as RecyclerView
        newsList?.setHasFixedSize(true)
        newsList?.layoutManager = LinearLayoutManager(context)
        return view
    }

}