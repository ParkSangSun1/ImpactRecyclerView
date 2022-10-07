package com.pss.impactrv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView

class ImpactAdapter : RecyclerView.Adapter<ImpactViewHolder>() {
    private lateinit var listener: ImpactRvListener
    private val itemList: ArrayList<ImpactRvItem> = ArrayList()
    private var context: Context? = null


    fun init(items: ArrayList<ImpactRvItem>, context: Context) {
        itemList.addAll(items)
        this.context = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImpactViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.impact_rv_item, parent, false)

        return ImpactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImpactViewHolder, position: Int) {
        holder.itemView.findViewById<ConstraintLayout>(R.id.background).setOnClickListener { listener.onClick(itemList[position%2], position%2) }

        holder.bind(item = itemList[position%2])
    }

    override fun getItemCount() = Int.MAX_VALUE

    fun listener(listener: ImpactRvListener) {
        this.listener = listener
    }
}

interface ImpactRvListener {

    fun onClick(item: ImpactRvItem, position: Int)
}