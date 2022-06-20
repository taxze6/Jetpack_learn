package com.taxze.jetpack.livedata_viewmodel.same

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.taxze.jetpack.livedata_viewmodel.R
import kotlinx.android.synthetic.main.fragment_right.*

class RightFragment : Fragment() {
    private val viewModel: BlankViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_right, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        right_button.setOnClickListener {
            viewModel.addOne()
        }
        activity?.let { it ->
            viewModel.getLiveData().observe(it) {
                right_text.text = it.toString()
            }
        }
    }
}