package com.littlecorgi.sunnyweather.ui.livedata

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataLiveBinding

class LiveDataLiveFragment : Fragment() {

    private lateinit var binding: FragmentLiveDataLiveBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataLiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    internal fun setTextViewString(s: String) {

    }
}