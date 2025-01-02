package com.rutvik.appraisal360.dashboardactivity.staff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rutvik.appraisal360.R

class StaffAdapter: RecyclerView.Adapter<StaffAdapter.StaffHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.staff_layout,parent,false)
        return StaffHolder(view)
    }

    override fun onBindViewHolder(holder: StaffHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class StaffHolder(view: View):ViewHolder(view) {

    }
}