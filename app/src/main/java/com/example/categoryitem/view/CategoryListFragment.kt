package com.example.categoryitem.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryitem.R
import com.example.categoryitem.adapter.CategoryListAdapter
import com.example.categoryitem.adapter.ItemAdapter
import com.example.categoryitem.viewmodel.CategoryViewModel

class CategoryListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView;

    private var linearLayoutManager: LinearLayoutManager? = null;
    private var itemAdapter: ItemAdapter? = null;
    lateinit var recyclerViewAdapter: CategoryListAdapter;
    lateinit var viewModelCategory: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_categorylist, container, false)

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_itembyCategory)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager


        viewModelCategory = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        viewModelCategory.getAllCategoryObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        fun newInstance(): CategoryListFragment = CategoryListFragment()
    }

    override fun onResume() {
        super.onResume()
    }
}