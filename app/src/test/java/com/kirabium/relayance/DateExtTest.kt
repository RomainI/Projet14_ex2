package com.kirabium.relayance

import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateExtTest{

    @Test
    fun toHumanDateTest() {
        // Arrange
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.set(2024, Calendar.DECEMBER, 7)
        val date = calendar.time

        // Act
        val inputDate = date.toHumanDate()

        // Assert
        val expectedDate = dateFormat.format(date)
        assertEquals(expectedDate, inputDate)
    }

}