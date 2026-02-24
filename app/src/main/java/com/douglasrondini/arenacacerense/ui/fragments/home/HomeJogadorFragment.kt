package com.douglasrondini.arenacacerense.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.douglasrondini.arenacacerense.R
import com.douglasrondini.arenacacerense.databinding.FragmentHomeJogadorBinding

class HomeJogadorFragment : Fragment() {

    private lateinit var binding: FragmentHomeJogadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeJogadorBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        binding.btnAgendarCampoA.setOnClickListener {
            findNavController().navigate(R.id.action_homeJogadorFragment_to_agendarCampoFragment)
        }
        binding.btnAgendarCampoB.setOnClickListener {
            findNavController().navigate(R.id.action_homeJogadorFragment_to_agendarCampoFragment)
        }
    }


}