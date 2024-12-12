package com.kirabium.relayance.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.kirabium.relayance.databinding.ActivityAddCustomerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddCustomerActivity : AppCompatActivity() {
    private val viewModel: AddCustomerViewModel by viewModels()

    private lateinit var binding: ActivityAddCustomerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupBinding() {
        binding = ActivityAddCustomerBinding.inflate(layoutInflater)
        val view = binding.root

        val emailEditText = binding.emailEditText
        val nameEditText = binding.nameEditText

        nameEditText.addTextChangedListener { text ->
            viewModel.onNameChanged(text.toString())
        }

        emailEditText.addTextChangedListener { text ->
            viewModel.onEmailChanged(text.toString())
        }


        val saveButton = binding.saveFab

        lifecycleScope.launch {
            viewModel.isSaveButtonEnabled.collect { isEnabled ->
                saveButton.isEnabled = isEnabled
            }

        }
        saveButton.setOnClickListener {
            viewModel.onSaveClicked()
            finish()
        }
        setContentView(view)
    }
}