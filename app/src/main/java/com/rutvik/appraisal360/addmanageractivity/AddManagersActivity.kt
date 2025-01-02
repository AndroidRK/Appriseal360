package com.rutvik.appraisal360.addmanageractivity

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rutvik.appraisal360.R
import com.rutvik.appraisal360.dashboardactivity.DashboardActivity
import com.rutvik.appraisal360.database.Manager
import com.rutvik.appraisal360.databinding.ActivityAddManagersBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar

@AndroidEntryPoint
class AddManagersActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityAddManagersBinding
    private  val mManagerViewModel: MangerViewModel by viewModels()
    private var mDobDate = ""
    private lateinit var mProgressDialog: ProgressDialog
    val departments = listOf("IT", "Sales", "Management")
    val genders = listOf("Male", "Female",)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init(){
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_managers)
         mProgressDialog = ProgressDialog(this)
        mProgressDialog.setTitle("This is TITLE")
        mProgressDialog.setMessage("This is MESSAGE")
        setSpinners()
        clickListener()
        setObserver()

    }


    private fun setObserver(){
        mManagerViewModel.validationStatus.observe(this, Observer {
            mProgressDialog.dismiss()

            startActivity(Intent(this,DashboardActivity::class.java))
            Toast.makeText(this, "Manager is added..", Toast.LENGTH_SHORT).show();

        })
    }

    private fun clickListener(){
        mBinding.mBtnAdd.setOnClickListener {
              try {
                  if(mBinding.firstNameEditText.text.toString().isEmpty()){
                      mBinding.firstNameEditText.error = "Please enter first name"
                  }
                  else if(mBinding.lastNameEditText.text.toString().isEmpty()){
                      mBinding.lastNameEditText.error = "Please enter last name"
                  }
                  else if(mBinding.mSpinnerDept.selectedItemPosition == 0){
                      Toast.makeText(this, "Please select department", Toast.LENGTH_SHORT).show();
                  }
                  else if(mBinding.phoneEditText.text.toString().isEmpty()){
                      mBinding.phoneEditText.error = "Invalid mobile no"
                  }
                  else if(mBinding.dobEditText.text.toString().isEmpty()){
                      Toast.makeText(this, "Please select date of birth", Toast.LENGTH_SHORT).show();
                  }

                  else if(mBinding.mSpinnerDept.selectedItemPosition == 0){
                      Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
                  }
                  else{
                      showDecisionAlertDialog(this,getString(R.string.app_name),"Are you sure you want to save this Manager?","Yes","No")
                  }
              }catch (e:Exception){
                  e.printStackTrace()
              }
        }

        mBinding.dobEditText.setOnClickListener {
            showDateDialog()
        }
    }
    fun showDecisionAlertDialog(context: Context, title: String, message:String, posVal:String, negVal:String){
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(posVal,object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    mProgressDialog.show()

                    mManagerViewModel.insertManager(Manager(
                       firstName =  mBinding.firstNameEditText.text.toString().trim(),
                       lastName =  mBinding.lastNameEditText.text.toString().trim(),
                       department =  departments[mBinding.mSpinnerDept.selectedItemPosition],
                       phoneNumber =  mBinding.phoneEditText.text.toString().trim(),
                       dateOfBirth =  mDobDate,
                       gender =  genders[mBinding.mSpinnerGender.selectedItemPosition],
                       averageReview = 5.0f ))
                    p0?.dismiss()
                }
            })
            .setNegativeButton(negVal,object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })
            .show()
    }

    private fun showDateDialog() {
        try {
            try {
                val calendar: Calendar = Calendar.getInstance()
                var year = calendar.get(Calendar.YEAR)
                var month = calendar.get(Calendar.MONTH)
                var day = calendar.get(Calendar.DAY_OF_MONTH)
                val mDatePicker = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                        mDobDate = "$day-${month + 1}-$year"
                        mBinding.dobEditText.setText(mDobDate)

                    },
                    year,
                    month,
                    day
                )
                mDatePicker.show()
            } catch (e: Exception) {

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun setSpinners(){
       try {
           val departmentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departments)
           departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
           mBinding.mSpinnerDept.adapter = departmentAdapter


           val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)
           genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
           mBinding.mSpinnerGender.adapter = genderAdapter
       }catch (e:Exception){
           e.printStackTrace()
       }
    }
}