package com.example.productivityapp.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.R
import java.time.LocalTime

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

        var constraintLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.cardViewConstraintlayout)

        val titleTextView = holder.itemView.findViewById<TextView>(R.id.titleTextView)
        val startTimeTextView = holder.itemView.findViewById<TextView>(R.id.timeTextView)
        val statusImageView = holder.itemView.findViewById<ImageView>(R.id.imageViewStatus)
        val iconImageView = holder.itemView.findViewById<ImageView>(R.id.imageViewTaskIcon)

        titleTextView.text = task.title
        startTimeTextView.text = task.startTime.toString()
        iconImageView.setImageResource(task.iconId)
        //Setting up alternate icon

//
        val currentTime = LocalTime.now()
        val isCurrent = currentTime.isAfter(task.startTime) && currentTime.isBefore(task.endTime)
//
        if(isCurrent){
            constraintLayout.setBackgroundResource(R.drawable.pink_gradient);
            startTimeTextView.setTextColor(ContextCompat.getColor(startTimeTextView.context, R.color.white))
            iconImageView.setImageResource(task.iconIdW)
            if(task.status)

                statusImageView.setImageResource(R.drawable.tickw)

            else statusImageView.setImageResource(R.drawable.crossw)

            statusImageView.setOnClickListener{
                if(task.status == false){
                    task.status = true
                    statusImageView.setImageResource(R.drawable.tickw)
                } else {
                    task.status = false
                    statusImageView.setImageResource(R.drawable.crossw)
                }
            }

        } else {
            iconImageView.setImageResource(task.iconId)
            if (task.status)
                statusImageView.setImageResource(R.drawable.tick)
            else statusImageView.setImageResource(R.drawable.cross)

            statusImageView.setOnClickListener{
                if(task.status == false){
                    task.status = true
                    statusImageView.setImageResource(R.drawable.tick)
                } else {
                    task.status = false
                    statusImageView.setImageResource(R.drawable.cross)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}