package com.littlecorgi.sunnyweather.ui.livedata.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.littlecorgi.sunnyweather.databinding.FragmentLiveDataBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LiveDataFragment : Fragment(), CoroutineScope {

    private lateinit var binding: FragmentLiveDataBinding

    private lateinit var viewModel: LiveDataViewModel

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.generateBtn.setOnClickListener {
            val a = (0..10000).random()
            launch {
                delay(1000)
                viewModel.setLiveDataA("$a")
            }
        }

        viewModel.liveDataA.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}