package com.example.myapplicationbindingdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationbindingdata.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    private lateinit var binding: FragmentBlank1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(MyViewModel ::class.java)
        model.message.observe(viewLifecycleOwner, {
            binding.textView.text = it
        })
    }
}