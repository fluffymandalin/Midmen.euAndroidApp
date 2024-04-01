package com.ozlemkilickiran.hw1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ozlemkilickiran.hw1.databinding.ActivityMain2Binding
import java.util.*


class MainActivity2 : AppCompatActivity() {

    //binding
    lateinit var binding: ActivityMain2Binding

    //spinner
    lateinit var eventItems: ArrayList<Event>
    lateinit var adapter: CustomSpinnerAdapter
    lateinit var spinnerEvents: Spinner
    lateinit var tvResult: TextView
    lateinit var tvPrice: TextView // Declare tvPrice TextView
    lateinit var eventPrices: List<EventPrice> // List to hold event prices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Retrieve intent if necessary
        val receivedIntent = intent

        // Initialize views
        tvResult = findViewById(R.id.tvResult)
        spinnerEvents = findViewById(R.id.spinnerEvents)
        tvPrice = findViewById(R.id.tvPrice) // Initialize tvPrice TextView

        // Prepare data for spinner
        prepareData()

        // Fill the custom spinner
        adapter = CustomSpinnerAdapter(this, eventItems)
        spinnerEvents.adapter = adapter

        spinnerEvents.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = eventItems[position] // Get the selected event
                val selectedPrice = eventPrices[position].price // Get the price using the same index as the event
                if (selectedItem.getName() != "Select an Event") { // Check if the selected item is not the title
                    tvResult.text = selectedItem.getName()
                    tvPrice.text = "Price: $$selectedPrice"
                    tvPrice.visibility = View.VISIBLE // Show price TextView
                } else {
                    tvResult.text = "" // Clear the text if "Select an Event" is selected
                    tvPrice.visibility = View.GONE // Hide price TextView
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        })

    }

    private fun prepareData() {
        eventItems = ArrayList()
        // Initialize event prices
        eventPrices = listOf(
            EventPrice("Select an Event", 0.0), // Add "Select an Event" with price 0.0
            EventPrice("Istanbul Nights", 29.99),
            EventPrice("KAPUT MUNDI - Tula Troubles Album Release Party", 39.99),
            EventPrice("Tula Troubles Live Music Concert in Diobar", 49.99),
            EventPrice("Tula Troubles Live Music Concert in Diobar", 49.99),
            EventPrice("Tula Troubles Live Music Concert in Diobar", 49.99),
            EventPrice("Tula Troubles Live Music Concert in Diobar", 49.99),
            EventPrice("Tula Troubles Live Music Concert in Diobar", 49.99)
        )

        // Combine event names and prices into eventItems list
        for ((index, eventPrice) in eventPrices.withIndex()) {
            if (index == 0) {
                // For "Select an Event" item, exclude icon and price
                eventItems.add(Event(eventPrice.eventName, 0)) // Set icon to 0 (no icon)
            } else {
                // For other events, include icon and price
                eventItems.add(Event(eventPrice.eventName, R.drawable.concerticon))
            }
        }
    }

}

