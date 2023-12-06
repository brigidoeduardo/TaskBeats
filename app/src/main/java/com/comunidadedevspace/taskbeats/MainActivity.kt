package com.comunidadedevspace.taskbeats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskList = listOf<Task>(

        )
// Adapter
        val adapter: TaskListAdapter = TaskListAdapter(taskList, ::openTaskDetailsView)

// Recycler View
        val rvTasks: RecyclerView = findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter
    }
// Launch TaskDetailsView
    fun openTaskDetailsView (task :Task){
        val intent = Intent(this, TaskDetailsActivity::class.java)
            .apply {
                putExtra(TaskDetailsActivity.TASK_TITLE_EXTRA, task.title)
            }
        startActivity(intent)

    }
}