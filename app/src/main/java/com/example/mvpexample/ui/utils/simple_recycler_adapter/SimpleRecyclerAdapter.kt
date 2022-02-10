package com.example.mvpexample.ui.utils.simple_recycler_adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleRecyclerAdapter<H : ISimpleRecyclerContract.ISimpleHolder>(
    protected val controller: ISimpleRecyclerContract.ISimpleHolderController<H>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ISimpleRecyclerContract.ISimpleRecyclerAdapter<H> {

    override var dataCount: Int = 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val typedHolder = holder as H
        controller.bindHolder(typedHolder)
    }

    override fun getItemCount(): Int = dataCount

    override fun setDiffResult(diffResult: DiffUtil.DiffResult) {
        diffResult.dispatchUpdatesTo(this)
    }

    override fun notifyDataChanges() {
        notifyDataSetChanged()
    }

}