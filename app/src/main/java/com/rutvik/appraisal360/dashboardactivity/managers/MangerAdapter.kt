package com.rutvik.appraisal360.dashboardactivity.managers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rutvik.appraisal360.R

class MangerAdapter: RecyclerView.Adapter<MangerAdapter.ManagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManagerHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.manager_layout,parent,false)
        return ManagerHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ManagerHolder, position: Int) {

    }

    class ManagerHolder(view:View):RecyclerView.ViewHolder(view) {

    }
}