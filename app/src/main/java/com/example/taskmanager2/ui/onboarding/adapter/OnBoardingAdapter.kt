package com.example.taskmanager2.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.taskmanager2.databinding.ItemOnboardingBinding
import com.example.taskmanager2.ui.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding("", "Title", "Desc"),
        OnBoarding("", "Title 2", "Desc 2"),
        OnBoarding("", "Title 3", "Desc 3")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(OnBoarding: OnBoarding) {


            binding.btnStart.setOnClickListener {
                onClick()
            }

            binding.btnSkip.setOnClickListener {
                onClick()
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnSkip.isVisible = adapterPosition != data.lastIndex
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
        }
    }


}