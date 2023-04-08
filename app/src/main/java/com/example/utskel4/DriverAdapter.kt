package com.example.utskel4

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.utskel4.databinding.ItemRowDriverBinding

class DriverAdapter(private val listDriver: ArrayList<Driver>) : RecyclerView.Adapter<DriverAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowDriverBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDriverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (first, last, image) = listDriver[position]
        holder.binding.tvFirstName.text = first
        holder.binding.tvLastName.text = last
        holder.binding.imgDriverPhoto.setImageResource(image)

        //activity on click
        holder.itemView.setOnClickListener() {
            val intentDetail = Intent(holder.itemView.context, DriverDetail::class.java)
            intentDetail.putExtra(
                DriverDetail.EXTRA_DRIVER,
                listDriver[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentDetail)
        }
    }


    override fun getItemCount(): Int = listDriver.size

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Driver)
    }



}