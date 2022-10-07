package com.pss.impactrv

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImpactRecyclerView @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attr, defStyleAttr) {
    private lateinit var impactAdapter: ImpactAdapter

    fun init(items: ArrayList<ImpactRvItem>, context: Context): ImpactRecyclerView {
        impactAdapter = ImpactAdapter()
        impactAdapter.init(items, context)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return this
    }

    fun listener(listener: ImpactRvListener): ImpactRecyclerView {
        impactAdapter.listener(listener)
        return this
    }

    fun build() {
        adapter = impactAdapter
    }
}
