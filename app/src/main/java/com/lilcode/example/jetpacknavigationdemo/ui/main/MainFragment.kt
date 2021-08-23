package com.lilcode.example.jetpacknavigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import com.lilcode.example.jetpacknavigationdemo.R
import com.lilcode.example.jetpacknavigationdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainButton.setOnClickListener {
            var action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.message = binding.userEditText.text.toString()
            Navigation.findNavController(it).navigate(action)
        }

        // 또는
        //binding.mainButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond, null))
    }

}