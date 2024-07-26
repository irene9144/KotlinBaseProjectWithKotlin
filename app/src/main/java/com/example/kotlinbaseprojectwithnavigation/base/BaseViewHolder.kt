package com.example.kotlinbaseprojectwithnavigation.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T : ViewBinding>(val binding: T): RecyclerView.ViewHolder(binding.root) {

}