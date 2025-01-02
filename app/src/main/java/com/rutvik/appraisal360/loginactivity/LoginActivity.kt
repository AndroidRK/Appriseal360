package com.rutvik.appraisal360.loginactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rutvik.appraisal360.R
import com.rutvik.appraisal360.dashboardactivity.DashboardActivity
import com.rutvik.appraisal360.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit  var mBinding:ActivityLoginBinding
    private lateinit var mLoginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init(){
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        mLoginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        clickListener()
        setObserver()
    }

    private fun clickListener(){
        mBinding.mBtnLogin.setOnClickListener {
                mLoginViewModel.validateCredentials(mBinding.mEdtUsername.text.toString().trim(),
                    mBinding.mEdtPassword.text.toString().trim())
        }
    }
    
    private fun setObserver(){
        mLoginViewModel.validationStatus.observe(this, Observer { 
            if(it == 1){
                mBinding.mEdtUsername.error = getString(R.string.invalid_password)
            }
            else if(it == 2){
                mBinding.mTxtPaswordError.visibility = View.VISIBLE
            }
            else{
                mBinding.mTxtPaswordError.visibility = View.GONE
                startActivity(Intent(this,DashboardActivity::class.java))
            }
        })
    }
}