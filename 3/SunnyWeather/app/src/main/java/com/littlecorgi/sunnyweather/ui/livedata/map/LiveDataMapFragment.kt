package com.littlecorgi.sunnyweather.ui.livedata.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import com.littlecorgi.sunnyweather.R
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataMapBinding
import com.littlecorgi.sunnyweather.ui.livedata.LiveDataLiveFragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LiveDataMapFragment : Fragment(), CoroutineScope {

    private lateinit var binding: FragmentLiveDataMapBinding

    lateinit var viewModel: LiveDataMapViewModel

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataMapBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LiveDataMapViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeLiveData()

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.fragment, LiveDataLiveFragment(this))
            ?.commit()

        binding.generateBtn.setOnClickListener {
            val a = (0..10000).random()
            launch {
                delay(1000)
                viewModel.setLiveDataA("$a")
            }
        }
    }

    private fun subscribeLiveData() {
        viewModel.liveDataA.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
    }
}