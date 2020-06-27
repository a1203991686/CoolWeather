package com.littlecorgi.sunnyweather.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataBinding

class LiveDataFragment : Fragment() {

    private lateinit var binding: FragmentLiveDataBinding

    private lateinit var viewModel: LiveDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        binding.generateBtn.setOnClickListener {
            val a = (0..10000).random()

        }

        return binding.root
    }
}