package com.test.recipes.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.test.recipes.R
import com.test.recipes.data.objects.Recipe

class CustomAdapter(private val list: List<Recipe>, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_list, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.images.text = list[position].images.toString()
        holder.description.text = list[position].description
        holder.view.setOnClickListener {
            onClick.invoke(list[position].uuid)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val view: ConstraintLayout = view.findViewById<ConstraintLayout>(R.id.item)
        val name: TextView = view.findViewById<TextView>(R.id.TextView)
        val images: TextView = view.findViewById<TextView>(R.id.TextView2)
        val description: TextView = view.findViewById(R.id.TextView3)
    }


    private fun <R> Function<R>.invoke(uuid: String) {
    }

}