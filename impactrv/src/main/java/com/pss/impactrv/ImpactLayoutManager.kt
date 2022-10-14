package com.pss.impactrv

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ImpactLayoutManager constructor(
    context: Context,
    orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        scrollHorizontallyBy(0, recycler, state)
        centerItemImpact()
    }

    override fun scrollVerticallyBy(dy: Int, recycler: Recycler?, state: RecyclerView.State?): Int {
        val orientation: Int = orientation
        return if (orientation == RecyclerView.VERTICAL) {
            val scrolled: Int = super.scrollVerticallyBy(dy, recycler, state)

            centerItemImpact()

            scrolled
        } else 0
    }

    private fun centerItemImpact(){
        val oChildX = 1.0f
        val oChildY = 1.0f
        val pChildX = 1.3f
        val pChildY = 1.3f

        for (i in 0 until childCount) {
            val child = getChildAt(i)

            if (child != null) {
                if (i == childCount / 2) child.apply {
                    pivotX = 0f
                    pivotY = 1f
                    scaleX = pChildX
                    scaleY = pChildY
                }
                else child.apply {
                    pivotX = 0f
                    pivotY = 1f
                    scaleX = oChildX
                    scaleY = oChildY
                }
            }
        }
    }
}