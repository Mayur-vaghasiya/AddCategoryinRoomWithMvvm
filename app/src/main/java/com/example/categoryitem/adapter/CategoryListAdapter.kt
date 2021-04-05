package com.example.categoryitem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryitem.R
import com.example.categoryitem.model.CategoryModel
import com.example.categoryitem.view.CategoryListFragment

class CategoryListAdapter(categoryListFragment: CategoryListFragment):RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    var items  = ArrayList<CategoryModel>()

    fun setListData(data: ArrayList<CategoryModel>) {
        this.items = data
    }
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.itemby_category, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
     return items.size;
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var category:AppCompatTextView;
        var item: AppCompatTextView;
        init {
            category = itemView.findViewById(R.id.actv_category)
            item = itemView.findViewById(R.id.actv_itemname)
        }

        fun bind(data: CategoryModel) {
            category.text = data.categoryName
            item.text = data.categoryItem.toString()
        }
    }
}