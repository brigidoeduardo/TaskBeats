package com.comunidadedevspace.taskbeats

import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import com.comunidadedevspace.taskbeats.presentation.ActionType
import com.comunidadedevspace.taskbeats.presentation.TaskAction
import com.comunidadedevspace.taskbeats.presentation.TaskListViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TaskListViewModelTest {

    private val taskDao : TaskDao = mock()

    private val underTest: TaskListViewModel by lazy {
        TaskListViewModel(taskDao)
    }
    @Test
    fun delete_all () = runTest{
       //GIVEN
        val taskAction = TaskAction (
            task = null,
            actionType = ActionType.DELETE_ALL.name
        )
        //WHEN
        underTest.execute(taskAction)
        //THEN
        verify(taskDao).deleteAll()
    }
    @Test
    fun update_task() = runTest{
        //GIVEN
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction (
            task = task,
            actionType = ActionType.UPDATE.name
        )
        //WHEN
        underTest.execute(taskAction)
        //THEN
        verify(taskDao).update(task)
    }
    @Test
    fun create_task() = runTest{
        //GIVEN
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction (
            task = task,
            actionType = ActionType.CREATE.name
        )
        //WHEN
        underTest.execute(taskAction)
        //THEN
        verify(taskDao).insert(task)
    }
    @Test
    fun deleteById_task() = runTest{
        //GIVEN
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction (
            task = task,
            actionType = ActionType.DELETE.name
        )
        //WHEN
        underTest.execute(taskAction)
        //THEN
        verify(taskDao).deleteById(task.id)
    }
}
