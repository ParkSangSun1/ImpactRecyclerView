package com.pss.impactrv

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class ImpactRecyclerView @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attr, defStyleAttr) {
    private lateinit var impactAdapter: ImpactAdapter
    private lateinit var snapHelper: PagerSnapHelper


    fun init(items: ArrayList<ImpactRvItem>, context: Context): ImpactRecyclerView {
        impactAdapter = ImpactAdapter()
        impactAdapter.init(items, context)
        layoutManager = ImpactLayoutManager(context = context, orientation = LinearLayoutManager.VERTICAL, reverseLayout = false)
        (layoutManager as ImpactLayoutManager).scrollToPositionWithOffset( Int.MAX_VALUE/2 , this.width/2)
        snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(this)

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
