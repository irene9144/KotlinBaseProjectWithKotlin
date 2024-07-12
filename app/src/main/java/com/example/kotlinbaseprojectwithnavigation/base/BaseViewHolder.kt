package com.example.kotlinbaseprojectwithnavigation.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseViewHolder<T>(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
    open fun bind(item: T) {
    }
}