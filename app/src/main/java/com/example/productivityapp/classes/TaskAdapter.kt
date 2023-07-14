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
        titleTextView.text = task.title
        startTimeTextView.text = task.startTime.toString()

        val currentTime = LocalTime.now()
        val isCurrent = currentTime.isAfter(task.startTime) && currentTime.isBefore(task.endTime)
//        if(isCurrent){
//            constraintLayout.setBackgroundResource(R.drawable.pink_gradient);
//            startTimeTextView.setTextColor(ContextCompat.getColor(startTimeTextView.context, R.color.white))
//            val tickResourceId = R.drawable.tickw
//            val crossResourceId = R.drawable.crossw
//        } else {
//            val tickResourceId = R.drawable.tick
//            val crossResourceId = R.drawable.cross
//        }
//
//
//        //Handling Tick/Cross Icon Click.
//        statusImageView.setOnClickListener{
//            if(task.status == false){
//                task.status = true
//                statusImageView.setImageResource(tickResourceId)
//            } else {
//                task.status = false
//                statusImageView.setImageResource(R.drawable.cross)
//            }
//        }
        if(isCurrent){
            constraintLayout.setBackgroundResource(R.drawable.pink_gradient);
            startTimeTextView.setTextColor(ContextCompat.getColor(startTimeTextView.context, R.color.white))
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