package com.example.categoryitem.view

import android.content.Context
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryitem.R
import com.example.categoryitem.adapter.ItemAdapter
import com.example.categoryitem.model.CategoryModel
import com.example.categoryitem.model.ItemModel
import com.example.categoryitem.viewmodel.CategoryViewModel
import com.example.categoryitem.viewmodel.ItemViewModel
import com.example.categoryitem.viewmodel.MainViewModelFactory

class CategoryFragment : Fragment(), View.OnClickListener {
    private lateinit var recyclerViewitem: RecyclerView;
    private lateinit var edittextCategory: AppCompatEditText;
    private lateinit var edittextItem: AppCompatEditText;
    private lateinit var btnaddItem: AppCompatTextView;
    private lateinit var btnsave: AppCompatTextView;
    private lateinit var viewModel: ItemViewModel;
    private lateinit var viewModelCategory:CategoryViewModel;
    private var itemList = ArrayList<ItemModel>()
    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val activity = activity as Context
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewitem = view.findViewById(R.id.recycler_item)
        edittextCategory = view.findViewById(R.id.edittext_addcategory)
        edittextItem = view.findViewById(R.id.edittext_additem)
        btnaddItem = view.findViewById(R.id.btn_add)
        btnaddItem.setOnClickListener(this);
        btnsave = view.findViewById(R.id.btn_submit)




        val factory = MainViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(ItemViewModel::class.java)
        viewModelCategory = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerViewitem.layoutManager = linearLayoutManager


        observeData()
    }

    fun observeData() {
        viewModel.lst.observe(this, Observer {
            Log.i("data", it.toString())
            itemList=it
            recyclerViewitem.adapter = ItemAdapter(viewModel, it, activity)
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                addData()
            }
            R.id.btn_submit -> {
                addCategory()
            }
        }
    }

    fun addData() {

        var title = edittextItem.text.toString()
        if (title.isNullOrBlank()) {
            Toast.makeText(activity, "Enter value!", Toast.LENGTH_LONG).show()
        } else {
            var item = ItemModel(title)
            viewModel.add(item)
            edittextItem.text?.clear()
            recyclerViewitem.adapter?.notifyDataSetChanged()
        }

    }

    fun addCategory() {

        var categoryTitle = edittextCategory.text.toString()
        if (categoryTitle.isNullOrBlank()) {
            Toast.makeText(activity, "Enter value!", Toast.LENGTH_LONG).show()
        } else {
            var categoryLists = CategoryModel(0,categoryTitle,itemList)
            viewModelCategory.insertUserInfo(categoryLists)
            edittextCategory.text?.clear()

        }

    }

}