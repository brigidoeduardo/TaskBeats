package com.comunidadedevspace.taskbeats

import com.comunidadedevspace.taskbeats.data.local.Task
import com.comunidadedevspace.taskbeats.data.local.TaskDao
import com.comunidadedevspace.taskbeats.presentation.taskdetails.ActionType
import com.comunidadedevspace.taskbeats.presentation.taskdetails.TaskAction
import com.comunidadedevspace.taskbeats.presentation.taskdetails.TaskDetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class TaskDetailsViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val taskDao : TaskDao = mock()
    private val underTest: TaskDetailsViewModel by lazy {
        TaskDetailsViewModel(
            taskDao,
        )
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