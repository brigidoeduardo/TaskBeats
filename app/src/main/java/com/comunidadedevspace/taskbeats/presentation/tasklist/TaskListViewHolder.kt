package com.comunidadedevspace.taskbeats.presentation.tasklist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.Task

class TaskListViewHolder (
    private val view: View
) : RecyclerView.ViewHolder(view) {
    private val tvTaskTitle = view.findViewById<TextView>(R.id.tv_task_title)
    private val tvTaskDescription = view.findViewById<TextView>(R.id.tv_task_description)

    fun bind (
        task: Task,
        openTaskDetailsActivity: (task: Task) -> Unit)
    {
        tvTaskTitle.text = task.title
        tvTaskDescription.text = task.description

        view.setOnClickListener{
            openTaskDetailsActivity.invoke(task)
        }
    }
}