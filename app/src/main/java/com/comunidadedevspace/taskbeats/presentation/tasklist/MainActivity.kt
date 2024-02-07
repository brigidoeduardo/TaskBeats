package com.comunidadedevspace.taskbeats.presentation.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.presentation.news.NewsListFragment
import com.comunidadedevspace.taskbeats.presentation.taskdetails.TaskDetailsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener{
        openTaskListDetail()
        }

        val taskListFragment = TaskListFragment.newInstance()
        val newsListFragment = NewsListFragment.newInstance()

        supportFragmentManager.commit {

            add(R.id.fragment_container_view, taskListFragment)
            setReorderingAllowed(true)
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.task_list -> taskListFragment
                R.id.news_list -> newsListFragment
                else -> taskListFragment
            }
            supportFragmentManager.commit {

                add(R.id.fragment_container_view, fragment)
                setReorderingAllowed(true)
            }

            true
        }
    }
    private fun openTaskListDetail (){
        val intent = TaskDetailsActivity.start(this, null)
        startActivity(intent)
    }
}