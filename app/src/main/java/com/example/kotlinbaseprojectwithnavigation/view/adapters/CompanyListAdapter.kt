package com.example.kotlinbaseprojectwithnavigation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlinbaseprojectwithnavigation.base.BaseAdapter
import com.example.kotlinbaseprojectwithnavigation.base.BaseViewHolder
import com.example.kotlinbaseprojectwithnavigation.databinding.CompanyItemBinding
import com.example.kotlinbaseprojectwithnavigation.service.model.Company

class CompanyListAdapter(private var companyList: List<Company>) :
    BaseAdapter<CompanyItemBinding, CompanyListAdapter.CompanyViewHolder, Company>(companyList) {

    override fun createViewHolder(binding: CompanyItemBinding): CompanyViewHolder {
        return CompanyViewHolder(binding)
    }


    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup): CompanyItemBinding {
        return CompanyItemBinding.inflate(inflater, parent, false)
    }

    override fun bind(holder: CompanyViewHolder, item: Company) {
        holder.bind(item)
    }

    inner class CompanyViewHolder(binding: CompanyItemBinding) :
        BaseViewHolder<CompanyItemBinding>(binding) {
        fun bind(data : Company) {
            binding.tvId.text = data.companyId.toString()
            binding.tvName.text = data.name.toString()
        }
    }


}