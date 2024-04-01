package com.ozlemkilickiran.hw1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomSpinnerAdapter(var contextt: Context, var spinnerItemValues: ArrayList<Event>) :
    ArrayAdapter<Event>(contextt, R.layout.spinner_item, spinnerItemValues) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = contextt.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflator.inflate(R.layout.spinner_item, parent, false)

        val constraintLayout: ConstraintLayout = view.findViewById(R.id.itemConstraintLayout)
        val imgItemEvent: ImageView = view.findViewById(R.id.imgItemEvent)
        val tvItemEventName: TextView = view.findViewById(R.id.tvItemEventName)

        val selectedItem = spinnerItemValues[position]
        tvItemEventName.text = selectedItem.getName()
        imgItemEvent.setImageResource(selectedItem.getImgId())
        if (position % 2 == 0)
            constraintLayout.setBackgroundColor(Color.TRANSPARENT)
        else
            constraintLayout.setBackgroundColor(Color.TRANSPARENT)
        return view
    }
}




