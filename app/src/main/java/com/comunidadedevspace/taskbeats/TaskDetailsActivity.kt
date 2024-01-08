package com.comunidadedevspace.taskbeats

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class TaskDetailsActivity : AppCompatActivity() {

    private var task : Task? = null
    private lateinit var tvTitle : TextView

    companion object{
        private const val TASK_DETAIL_EXTRA = "task.extra.detail"
        fun start(context : Context, task: Task?): Intent {
            val intent = Intent(context, TaskDetailsActivity::class.java)
                .apply {
                    putExtra(TASK_DETAIL_EXTRA, task)
                }
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val task = intent.getSerializableExtra(TASK_DETAIL_EXTRA) as Task?


        tvTitle = findViewById(R.id.tvtitle)

        tvTitle.text = task?.title ?: "Add a task"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_task_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_task -> {

                if (task != null) {
                    val intent = Intent()
                        .apply {
                            val actionType = ActionType.DELETE
                            val taskAction = TaskAction(task!!, actionType)
                            putExtra("TASK_ACTION_RESULT", taskAction)
                        }
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    showMessage(tvTitle, "Item not found")
                }
                    true
                }

                else -> return super.onOptionsItemSelected(item)
            }
        }

        fun showMessage(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
}
