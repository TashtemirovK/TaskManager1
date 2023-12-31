package com.example.taskmanager2.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.FragmentTaskBinding
import com.example.taskmanager2.ui.task.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.toString().isNotEmpty()){
                findNavController().navigateUp()
            }else{
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                binding.etTitle.error = "ERROR"
                return@setOnClickListener
            }
            val data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesk.text.toString()
            )
            setFragmentResult(RESULT_KEY, bundleOf(TASK_KEY to data))
        }
    }

    companion object {
        const val RESULT_KEY = "result_key"
        const val TASK_KEY = "task_key"
    }
}