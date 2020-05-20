package com.sasuke.launcheroneplus.util

import android.app.Activity
import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sasuke.launcheroneplus.data.model.App
import java.util.*

fun String.toLowerCased(): String = this.toLowerCase(Locale.getDefault())


inline fun <reified T : RecyclerView.ViewHolder> RecyclerView.forEachVisibleHolder(
    action: (T) -> Unit
) {
    for (i in 0 until childCount) {
        action(getChildViewHolder(getChildAt(i)) as T)
    }
}

fun Activity.openApp(appInfo: App) {
    packageManager.getLaunchIntentForPackage(appInfo.packageName)?.let {
        startActivity(it)
    }
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

