package com.kirabium.relayance.repository

import android.util.Log
import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.domain.model.Customer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(
    dummyData: DummyData
) {

    private val _customers = MutableStateFlow(dummyData.getInitialCustomers())
    val customers: StateFlow<List<Customer>> = _customers

    fun insert(customer: Customer) {
        _customers.value = _customers.value + customer
    }

    fun getData(): List<Customer> {
        return _customers.value
    }
}


