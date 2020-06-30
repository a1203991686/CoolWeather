package com.littlecorgi.sunnyweather.ui.livedata.switchmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataSwitchMapBinding

class LiveDataSwitchMapFragment : Fragment() {

    private lateinit var binding: FragmentLiveDataSwitchMapBinding

    private lateinit var viewModel: LiveDataSwitchMapViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataSwitchMapBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LiveDataSwitchMapViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}