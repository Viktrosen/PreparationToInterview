package com.example.preparationtointerview.view

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.preparationtointerview.R
import com.example.preparationtointerview.model.MainModel
import com.example.preparationtointerview.presenter.SettingsPresenter

class SettingsAdapter(var presenter: SettingsPresenter): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MarkerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {

            val markerName = itemView.findViewById<TextView>(R.id.marker_name)
            val markerNotation = itemView.findViewById<TextView>(R.id.marker_notation)
            val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteButton)

            markerName.text = MainModel.arrayOfMarkers[position].second
            markerNotation.text = "Some notation"

            deleteButton.setOnClickListener {
                presenter.delete(position)
                notifyItemRemoved(position)
            }


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MarkerViewHolder(inflater.inflate(R.layout.item_marker, parent, false) as View)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MarkerViewHolder
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return MainModel.arrayOfMarkers.size
    }
}