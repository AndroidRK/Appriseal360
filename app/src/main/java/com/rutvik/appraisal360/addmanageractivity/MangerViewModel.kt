package com.rutvik.appraisal360.addmanageractivity

import android.app.Application
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rutvik.appraisal360.database.Manager
import com.rutvik.appraisal360.database.ManagerDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangerViewModel @Inject  constructor(val managerDao: ManagerDao,application: Application):AndroidViewModel(application){
    private val _validationStatus = MutableLiveData<Int>()
    val validationStatus: LiveData<Int> get() = _validationStatus


    fun  insertManager(manager: Manager){
viewModelScope.launch {

    managerDao.Insert(manager)
    _validationStatus.value = 1
}
    }



}