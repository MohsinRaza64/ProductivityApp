package com.example.productivityapp.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.R

class TaskAdapter(
    var tasks: List<Task>
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item_card, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        val titleTextView = holder.itemView.findViewById<TextView>(R.id.titleTextView)
        val startTimeTextView = holder.itemView.findViewById<TextView>(R.id.timeTextView)
        titleTextView.text = task.title
        startTimeTextView.text = task.startTime.toString()
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}