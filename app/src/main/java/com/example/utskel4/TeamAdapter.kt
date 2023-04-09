package com.example.utskel4

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.utskel4.databinding.ItemRowTeamsBinding

class TeamAdapter(private val listTeam: ArrayList<Team>) : RecyclerView.Adapter<TeamAdapter.ListViewHolder>() {
    class ListViewHolder (val binding: ItemRowTeamsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (team, image) = listTeam[position]
        holder.binding.tvTeam.text = team
        holder.binding.imgCar.setImageResource(image)

        //activity on click
        holder.itemView.setOnClickListener {
            val intentTeamDetail = Intent(holder.itemView.context, TeamDetail::class.java)
            intentTeamDetail.putExtra(
                TeamDetail.EXTRA_TEAM,
                listTeam[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentTeamDetail)
        }
    }

    override fun getItemCount(): Int = listTeam.size

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Team)
    }


}