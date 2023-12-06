package com.comunidadedevspace.taskbeats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView

class TaskDetailsActivity : AppCompatActivity() {

    companion object{
        val TASK_TITLE_EXTRA = "task.title.extra.detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val title: String = intent.getStringExtra(TASK_TITLE_EXTRA) ?:""
        val tvTitle = findViewById<TextView>(R.id.tvtitle)

        tvTitle.text = title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_task_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_task -> {
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}