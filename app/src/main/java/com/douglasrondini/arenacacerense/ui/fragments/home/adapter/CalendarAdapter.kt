package com.douglasrondini.arenacacerense.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasrondini.arenacacerense.R
import com.douglasrondini.arenacacerense.databinding.ItemCalendarBinding
import com.douglasrondini.arenacacerense.ui.fragments.home.model.DataCalendar

class CalendarAdapter(
    private val list: List<DataCalendar>
): RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemCalendarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.bind(list[position], position == selectedPosition)

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position

            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)


        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        val binding: ItemCalendarBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataCalendar, isSelected: Boolean) {
            binding.mes.text = item.mes
            binding.dia.text = item.dia
            binding.diaSemana.text = item.diaSemana

            if (isSelected) {
                binding.root.setBackgroundResource(R.drawable.bg_pill_selected)
                binding.mes.setTextColor(binding.root.context.getColor(R.color.white))
                binding.dia.setTextColor(binding.root.context.getColor(R.color.white))
                binding.diaSemana.setTextColor(binding.root.context.getColor(R.color.white))
            } else {

                binding.root.setBackgroundResource(R.drawable.bg_pill_default)
                binding.mes.setTextColor(binding.root.context.getColor(R.color.primary))
                binding.dia.setTextColor(binding.root.context.getColor(R.color.black))
                binding.diaSemana.setTextColor(binding.root.context.getColor(R.color.primary))
            }
        }
    }
}