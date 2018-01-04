@file:JvmName("ExtensionsUtils")

package xur.com.myreddit.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by xur on 2018/1/4.
 */
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}