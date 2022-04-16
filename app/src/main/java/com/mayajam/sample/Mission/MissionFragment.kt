package com.mayajam.sample.Mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayajam.sample.databinding.FragmentMissionBinding

class MissionFragment : Fragment() {
    private lateinit var binding: FragmentMissionBinding
    private lateinit var viewModel: MissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMissionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(MissionViewModel::class.java)
        viewModel.getMissions()
        addMissionListener()
    }

    private fun addMissionListener() {
        viewModel.missions.observe(this, Observer<Array<Mission>> { missionList ->
            fillMissionList(missionList)
        })
    }

    private fun fillMissionList(missionList: Array<Mission>) {
        binding.rvMissionList.layoutManager = LinearLayoutManager(context)
        binding.rvMissionList.adapter = MissionAdapter(missionList)

    }
}