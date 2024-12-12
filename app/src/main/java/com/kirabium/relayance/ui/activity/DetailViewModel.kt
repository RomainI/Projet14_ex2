package com.kirabium.relayance.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun getCustomer(index: Int): Customer? {
        val customers = repository.getData()
//        Log.d("INDEX",""+ index)
        return customers[index-1]
    }
}