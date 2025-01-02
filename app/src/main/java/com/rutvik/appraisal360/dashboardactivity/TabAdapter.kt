package com.rutvik.appraisal360.dashboardactivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rutvik.appraisal360.dashboardactivity.managers.ManagerFragment
import com.rutvik.appraisal360.dashboardactivity.staff.StaffFragment

class TabAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0-> ManagerFragment()
            1->StaffFragment()
            else-> throw IllegalStateException("Invalid position")
        }
    }

}