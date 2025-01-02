package com.rutvik.appraisal360.dashboardactivity.staff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rutvik.appraisal360.R

class StaffFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.staff_fragment_layout,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.mRecyclerViewStaff)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = StaffAdapter()
        return view
    }
}