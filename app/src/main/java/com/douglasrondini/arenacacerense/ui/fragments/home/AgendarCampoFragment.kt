package com.douglasrondini.arenacacerense.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglasrondini.arenacacerense.R
import com.douglasrondini.arenacacerense.databinding.FragmentAgendarCampoBinding
import com.douglasrondini.arenacacerense.ui.fragments.home.adapter.CalendarAdapter
import com.douglasrondini.arenacacerense.ui.fragments.home.model.DataCalendar
import com.google.android.material.datepicker.MaterialDatePicker

class AgendarCampoFragment : Fragment() {
    private lateinit var binding: FragmentAgendarCampoBinding

    private var selectdButton: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgendarCampoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val listaDatas = listOf(
            DataCalendar("Fev", "16", "Seg"),
            DataCalendar("Fev", "17", "Ter"),
            DataCalendar("Fev", "18", "Qua"),
            DataCalendar("Fev", "19", "Qui"),
            DataCalendar("Fev", "20", "Sex"),
            DataCalendar("Fev", "21", "Sab"),
            DataCalendar("Fev", "22", "Dom")
        )

        val adapter = CalendarAdapter(listaDatas)
        binding.recyclerViewData.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
            setHasFixedSize(true)
        }

        val buttons = listOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                // resetar o anterior
                selectdButton?.apply {
                    setBackgroundResource(R.drawable.bg_pill_default)
                    // volta o texto para preto
                    (getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.black, null))
                }

                // marcar o novo selecionado
                button.setBackgroundResource(R.drawable.bg_pill_selected)
                // deixa o texto branco
                (button.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.white, null))

                // atualizar referência
                selectdButton = button

                // capturar o texto
                val time = (button.getChildAt(0) as TextView).text.toString()
            }
        }

        binding.radioPix.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.radioLocal.isChecked = false
                binding.layoutPix.setBackgroundResource(R.drawable.bg_pill_selected)
                binding.layoutLocal.setBackgroundResource(R.drawable.bg_pill_default)
                binding.txtPix.setTextColor(requireContext().getColor(R.color.white))
                binding.txtLocal.setTextColor(requireContext().getColor(R.color.black))
            }
        }

        binding.radioLocal.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.radioPix.isChecked = false
                binding.layoutLocal.setBackgroundResource(R.drawable.bg_pill_selected)
                binding.layoutPix.setBackgroundResource(R.drawable.bg_pill_default)
                binding.txtLocal.setTextColor(requireContext().getColor(R.color.white))
                binding.txtPix.setTextColor(requireContext().getColor(R.color.black))
            }
        }







    }




}