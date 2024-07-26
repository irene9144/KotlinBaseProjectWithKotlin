package com.example.kotlinbaseprojectwithnavigation.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<VB : ViewBinding, VH : BaseViewHolder<VB>, T>(private val dataList: List<T>) :
    RecyclerView.Adapter<VH>() {
    //
//        interface ItemClickListener<T> {
//            fun onClickItem(view: View, item: T, position: Int)
//        }
//
//    private var onItemClickListener: ItemClickListener<T>?= null
//
//    fun setOnItemClickListener(listener: (view: View, T, position: Int)-> Unit) {
//        onItemClickListener = object: ItemClickListener<T> {
//            override fun onClickItem(view: View, item: T, position: Int) {
//                listener(view, item, position)
//            }
//        }
//    }
    abstract fun createViewHolder(binding: VB): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = createBinding(LayoutInflater.from(parent.context), parent)
        return createViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        bind(holder, dataList[position])
//
//        holder.itemView.setOnClickListener{
//            onItemClickListener?.onClickItem(holder.itemView, getItem(position), position)
//        }

    }

    override fun getItemCount(): Int = dataList.size

    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): VB
    abstract fun bind(holder: VH, item: T)

}