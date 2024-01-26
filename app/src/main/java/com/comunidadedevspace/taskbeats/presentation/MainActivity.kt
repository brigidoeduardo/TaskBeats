package com.comunidadedevspace.taskbeats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

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
}