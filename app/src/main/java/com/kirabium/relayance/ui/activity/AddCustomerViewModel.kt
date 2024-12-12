package com.kirabium.relayance.ui.activity

import androidx.lifecycle.ViewModel
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class AddCustomerViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _isSaveButtonEnabled = MutableStateFlow(false)
    val isSaveButtonEnabled: StateFlow<Boolean> = _isSaveButtonEnabled

    fun onNameChanged(inputName: String) {
        _name.value = inputName
        validateInput()
    }

    fun onEmailChanged(inputEmail: String) {
        _email.value = inputEmail
        validateInput()
    }

    fun onSaveClicked() {
        val newCustomer = Customer(
            repository.getData().size + 1,
            name.value,
            email.value,
            Calendar.getInstance().time
        )
        repository.insert(newCustomer)
    }

    private fun validateInput() {
        _isSaveButtonEnabled.value = _name.value.isNotBlank() && _email.value.isNotBlank()
    }
}