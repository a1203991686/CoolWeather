package com.littlecorgi.sunnyweather.ui.livedata.switchmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.littlecorgi.sunnyweather.R
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataSwitchMapBinding
import com.littlecorgi.sunnyweather.ui.livedata.LiveDataLiveFragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LiveDataSwitchMapFragment : Fragment(), CoroutineScope {

    private lateinit var binding: FragmentLiveDataSwitchMapBinding

    lateinit var viewModel: LiveDataSwitchMapViewModel

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

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

        binding.generateABtn.setOnClickListener {
            val a = (0..10000).random()
            launch {
                delay(1000)
                viewModel.setLiveDataA("$a")
            }
        }

        binding.generateBBtn.setOnClickListener {
            val a = (0..10000).random()
            launch {
                delay(1000)
                viewModel.setLiveDataB("$a")
            }
        }

        binding.switchA.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setSwitchLiveData(isChecked)
        }

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.fragment, LiveDataLiveFragment(this))
            ?.commit()

        subscribeLiveData()
    }

    private fun subscribeLiveData() {
        viewModel.liveDataA.observe(viewLifecycleOwner, Observer {
            binding.textViewA.text = it
        })
        viewModel.liveDataB.observe(viewLifecycleOwner, Observer {
            binding.textViewB.text = it
        })
    }
}