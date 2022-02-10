package com.example.mvpexample.ui.utils.simple_recycler_adapter

import androidx.recyclerview.widget.DiffUtil

interface ISimpleRecyclerContract {

    interface ISimpleHolder {
        fun getAdapterPosition(): Int
    }

    interface ISimpleRecyclerAdapter<H : ISimpleHolder> {
        var dataCount: Int
        fun setDiffResult(diffResult: DiffUtil.DiffResult)
        fun notifyDataChanges()
    }

    interface ISimpleHolderController<H : ISimpleHolder> {
        fun bindHolder(holder: H)
        fun onHolderClick(holder: H)
    }

}