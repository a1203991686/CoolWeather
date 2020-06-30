package com.littlecorgi.sunnyweather.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataLiveBinding
import com.littlecorgi.sunnyweather.ui.livedata.livedata.LiveDataFragment
import com.littlecorgi.sunnyweather.ui.livedata.map.LiveDataMapFragment

class LiveDataLiveFragment(private val f: Fragment) : Fragment() {

    private lateinit var binding: FragmentLiveDataLiveBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataLiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        when (f) {
            is LiveDataFragment -> {
                f.viewModel.liveDataA.observe(viewLifecycleOwner, Observer {
                    binding.textView.text = it
                })
            }
            is LiveDataMapFragment -> {
                f.viewModel.liveDataA.map { str ->
                    "A: $str"
                }.observe(viewLifecycleOwner, Observer {
                    binding.textView.text = it
                })
            }
        }
    }
}