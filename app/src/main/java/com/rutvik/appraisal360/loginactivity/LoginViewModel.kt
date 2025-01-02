package com.rutvik.appraisal360.loginactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {

    private val _validationStatus = MutableLiveData<Int>()
    val validationStatus:LiveData<Int> get() = _validationStatus

   private fun isValidEmail(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

   private fun isPasswordValid(password:String):Boolean{
        val passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,}$"
        return password.matches(Regex(passwordPattern))
    }

    fun validateCredentials(email: String,password: String){
        if(!isValidEmail(email)){
            _validationStatus.value = 1
        }else if(!isPasswordValid(password)){
            _validationStatus.value = 2
        }else {
            _validationStatus.value =3
        }
    }

}