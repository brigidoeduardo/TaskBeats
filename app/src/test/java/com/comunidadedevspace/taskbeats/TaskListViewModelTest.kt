package com.comunidadedevspace.taskbeats

import com.comunidadedevspace.taskbeats.data.local.TaskDao
import com.comunidadedevspace.taskbeats.presentation.tasklist.TaskListViewModel
import org.mockito.kotlin.mock

class TaskListViewModelTest {

    private val taskDao : TaskDao = mock()

    private val underTest: TaskListViewModel by lazy {
        TaskListViewModel(taskDao)
    }

}
