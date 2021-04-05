package com.example.categoryitem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryitem.R
import com.example.categoryitem.model.ItemModel
import com.example.categoryitem.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.itemlist.view.*

class ItemAdapter(
    val viewModel: ItemViewModel,
    val arrayList: ArrayList<ItemModel>,
    val context: FragmentActivity?
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup, viewType: Int
    ): ItemAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.itemlist, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        return arrayList.size;
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemmodel: ItemModel){
            itemView.actv_itemname.text = itemmodel.Item

        }
    }
}