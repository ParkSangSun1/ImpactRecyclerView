package com.pss.impactrv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImpactViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    fun bind(item: ImpactRvItem) {
        view.apply {
            findViewById<TextView>(R.id.txt).text = item.text

            Glide.with(this)
                .load(item.url)
                .circleCrop()
                .into(findViewById(R.id.imageView))
        }
    }
}
