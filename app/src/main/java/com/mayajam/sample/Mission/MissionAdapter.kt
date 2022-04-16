package com.mayajam.sample.Mission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mayajam.sample.R

class MissionAdapter(private val missionList:Array<Mission>) : RecyclerView.Adapter<MissionAdapter.MissionViewHolder>() {

    class MissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val missionId: TextView
        val missionName: TextView

        init {
            missionId = itemView.findViewById(R.id.tv_mission_id)
            missionName = itemView.findViewById(R.id.tv_mission_name)
        }

        fun setData(mission:Mission){
            missionId.setText(mission.mission_id)
            missionName.setText(mission.missionName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mission, parent, false)
        return MissionViewHolder(view)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        holder.setData(missionList.get(position))
    }

    override fun getItemCount(): Int {
        return missionList.size
    }
}