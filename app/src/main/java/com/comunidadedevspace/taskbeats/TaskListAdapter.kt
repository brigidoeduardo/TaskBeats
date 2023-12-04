package com.comunidadedevspace.taskbeats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter (
    private val titles : List <Task>,
    private val openTaskDetailsActivity: (task: Task) -> Unit
):
    RecyclerView.Adapter<TaskListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_item, parent,false)

        return TaskListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = titles[position]
        holder.bind(task, openTaskDetailsActivity)
    }
}

class TaskListViewHolder (
    private val view: View
) : RecyclerView.ViewHolder(view)
    {
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