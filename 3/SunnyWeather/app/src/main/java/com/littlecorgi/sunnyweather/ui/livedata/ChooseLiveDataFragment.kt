package com.littlecorgi.sunnyweather.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.littlecorgi.sunnyweather.R
import kotlinx.android.synthetic.main.fragment_choose_live_data.*

class ChooseLiveDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_live_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)

        toLiveDataFragmentBtn.setOnClickListener {
            navController.navigate(R.id.action_changeLiveDataFragment_to_liveDataFragment)
        }
    }
}