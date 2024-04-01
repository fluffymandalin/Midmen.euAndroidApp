package com.ozlemkilickiran.hw1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var eventItems: ArrayList<EventImage>
    private lateinit var mainImage: ImageView
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mainImage = findViewById(R.id.mainImage)
        val spinnerEvents: Spinner = findViewById(R.id.spinnerEvents)
        tvResult = findViewById(R.id.tvResult)

        prepareData()

        spinnerEvents.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = eventItems[position] // Get the selected event
                val imageResourceId = selectedItem.imageResourceId // Obtain the image resource ID from the selected event

                mainImage.setImageResource(imageResourceId) // Set the image resource to the ImageView

                // Update the TextView with the name of the selected event
                tvResult.text = selectedItem.name
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        })
    }

    private fun prepareData() {
        eventItems = ArrayList()
        eventItems.add(EventImage("Select an Event", R.drawable.mainpage))
        eventItems.add(EventImage("Istanbul Nights", R.drawable.firstevent))
        eventItems.add(EventImage("KAPUT MUNDI - Tula Troubles Album Release Party", R.drawable.secondevent))
        eventItems.add(EventImage("Tula Troubles Live Music Concert in Diobar", R.drawable.thirdevent))
    }
}
