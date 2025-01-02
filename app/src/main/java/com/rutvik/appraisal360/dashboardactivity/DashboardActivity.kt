package com.rutvik.appraisal360.dashboardactivity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.rutvik.appraisal360.R
import com.rutvik.appraisal360.databinding.ActivityDashboardBinding
import com.rutvik.appraisal360.databinding.ActivityLoginBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init(){
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard)

        mBinding.mViewPager.adapter = TabAdapter(this)
        TabLayoutMediator(mBinding.mTabLayout,mBinding.mViewPager){tab,postition->
            tab.text = if (postition==0) "Managers" else "Staff"
        }.attach()

        setSupportActionBar(mBinding.toolbar)

        val toggle =  ActionBarDrawerToggle(
            this,mBinding.drawerLayout,mBinding.toolbar,R.string.open_drawer,R.string.close_drawer
        )
        toggle.syncState()
        clickListener()
    }

    private fun clickListener(){
        mBinding.navigationView.setNavigationItemSelectedListener {menuItem:MenuItem->

            when(menuItem.itemId){
                R.id.drawer_dashboard->{
                    Toast.makeText(this@DashboardActivity, "Dashboard Menu", Toast.LENGTH_SHORT).show();
                }
                R.id.drawer_profile->{
                    Toast.makeText(this@DashboardActivity, "Profile Menu", Toast.LENGTH_SHORT).show();
                }
                R.id.drawer_logout->{

                }
            }
            mBinding.drawerLayout.closeDrawers()
            true
        }
    }
}