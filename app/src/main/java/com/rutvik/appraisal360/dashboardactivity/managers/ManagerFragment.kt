package com.rutvik.appraisal360.dashboardactivity.managers

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.rutvik.appraisal360.R
import com.rutvik.appraisal360.addmanageractivity.AddManagersActivity

class ManagerFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.manager_fragment_layout,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.mRecyclerViewManager)
        val mBtnAddManager =  view.findViewById<ExtendedFloatingActionButton>(R.id.mBtnAddManager)
        mBtnAddManager.setOnClickListener {
            startActivity(Intent(context, AddManagersActivity::class.java))
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MangerAdapter()
        return view
    }

}