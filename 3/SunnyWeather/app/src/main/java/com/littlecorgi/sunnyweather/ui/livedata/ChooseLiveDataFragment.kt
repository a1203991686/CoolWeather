package com.littlecorgi.sunnyweather.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.littlecorgi.sunnyweather.R
import com.littlecorgi.sunnyweather.databinding.FragmentChooseLiveDataBinding

class ChooseLiveDataFragment : Fragment() {

    private lateinit var binding: FragmentChooseLiveDataBinding

    private val navController = NavHostFragment.findNavController(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseLiveDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toLiveDataFragmentBtn.setOnClickListener {
            navController.navigate(R.id.action_changeLiveDataFragment_to_liveDataFragment)
        }
    }
}