package com.taxze.jetpack.livedata_viewmodel.same

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.livedata_viewmodel.R
import kotlinx.android.synthetic.main.fragment_left.*


class LeftFragment : Fragment() {
    private val viewModel:BlankViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        left_button.setOnClickListener {
            viewModel.addOne()
        }
        activity?.let {it ->
            viewModel.getLiveData().observe(it){
                left_text.text = it.toString()
            }
        }
    }

}