package com.hashinology.recyclerviewkotlinwithretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.recyclerviewkotlinwithretrofit.R
import com.hashinology.recyclerviewkotlinwithretrofit.models.ModelList
import com.hashinology.recyclerviewkotlinwithretrofit.ui.AdapterInterface

class MyAdapter(private val modelList: List<ModelList>, val context: Context, val adapterInterface: AdapterInterface): RecyclerView.Adapter<MyAdapter.MyViews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViews {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViews(view)
    }

    override fun onBindViewHolder(holder: MyViews, position: Int) {
        val myList = modelList.get(position)
        holder.tvName.text = myList.name
        holder.tvGender.text = myList.gender
        holder.tvProbability.text = myList.probability.toString()
        holder.tvCount.text = myList.count.toString()

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    inner class MyViews(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvGender = itemView.findViewById<TextView>(R.id.tvGender)
        val tvProbability = itemView.findViewById<TextView>(R.id.tvProbability)
        val tvCount = itemView.findViewById<TextView>(R.id.tvCount)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View) {
            adapterInterface.getAdapterInterface(p0, adapterPosition)
        }
    }
}