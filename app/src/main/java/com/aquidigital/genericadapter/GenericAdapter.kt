package com.aquidigital.genericadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kasturi.admin.genericadapter.JavaViewHolderFactory

abstract class GenericAdapter<T>(var listItems: List<T> = emptyList()) : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    fun setItems(listItems: List<T>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false), viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(listItems[position])
    }

    override fun getItemCount() = listItems.size

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, listItems[position])
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    private fun getViewHolder(view: View, viewType: Int):RecyclerView.ViewHolder{
            return JavaViewHolderFactory.create(view, viewType)
    }

    internal interface Binder<T> {
        fun bind(data: T)
    }
}
