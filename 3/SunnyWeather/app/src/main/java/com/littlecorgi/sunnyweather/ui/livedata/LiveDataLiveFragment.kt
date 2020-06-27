package com.littlecorgi.sunnyweather.ui.livedata

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.littlecorgi.sunnyweather.R

class LiveDataLiveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_live_data_live, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
}