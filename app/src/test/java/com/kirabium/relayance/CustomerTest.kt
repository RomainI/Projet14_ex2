package com.kirabium.relayance

import com.kirabium.relayance.domain.model.Customer
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.util.Calendar

class CustomerTest {

    @Test
    fun isNewCustomerTestingTrue() {
        // Arrange
        val twoMonthsDate = Calendar.getInstance().apply {
            add(Calendar.MONTH, -2)
        }.time
        val customer = Customer(1, "Bobby", "bob.lebricoleur@gmail.com", twoMonthsDate)

        // Act
        val result = customer.isNewCustomer()

        // Assert
        assertTrue(result)
    }

    @Test
    fun isNewCustomerTestingFalse() {
        // Arrange
        val fourMonthsDate = Calendar.getInstance().apply {
            add(Calendar.MONTH, -4)
        }.time
        val customer = Customer(2, "Bobette", "bobette@gmail.com", fourMonthsDate)

        // Act
        val result = customer.isNewCustomer()

        // Assert
        assertFalse(result)
    }


}