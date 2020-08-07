package com.tutorials.tutorial2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener{ view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "Date Picker selected", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                val todayDate = "$day/${month+1}/$year"

                tvSelectedDate.setText(selectedDate)

                val simpleSelectedDate = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val simpleTodayDate = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val chosenDate = simpleSelectedDate.parse(selectedDate)
                val todaysDate = simpleTodayDate.parse(todayDate)
                val difference = todaysDate.time - chosenDate.time
                val seconds = difference/1000
                val minutes = seconds/60
                val hours = minutes/60
                val days = hours/24

                tvSelectedDateInMinutes.setText(minutes.toString())
            }, year, month, day).show()
    }
}