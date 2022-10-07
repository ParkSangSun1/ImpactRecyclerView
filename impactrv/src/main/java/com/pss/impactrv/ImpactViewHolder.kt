package com.pss.impactrv

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class ImpactViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    fun bind(item: ImpactRvItem){
        view.apply {
            findViewById<TextView>(R.id.txt).text = item.text

            setImageView(item)
        }
    }

    private fun setImageView(item: ImpactRvItem){
        coroutineScope.launch {
            val originalDeferred = coroutineScope.async(Dispatchers.IO) {
                getOriginalBitmap(item.url)
            }
            view.findViewById<ImageView>(R.id.imageView).setImageBitmap(originalDeferred.await())
        }
    }

    private fun getOriginalBitmap(url: String): Bitmap =
        URL(url).openStream().use {
            BitmapFactory.decodeStream(it)
        }
}
