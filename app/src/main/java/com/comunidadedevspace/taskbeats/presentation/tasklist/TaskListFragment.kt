package com.comunidadedevspace.taskbeats.presentation.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.local.Task
import com.comunidadedevspace.taskbeats.presentation.taskdetails.TaskDetailsActivity

class TaskListFragment : Fragment() {

    //Empty State
    private lateinit var ctnContent: LinearLayout

    // Adapter
    private val adapter: TaskListAdapter by lazy {
        TaskListAdapter(::openTaskListDetail)
    }
    //View Model
    private val viewModel: TaskListViewModel by lazy {
        TaskListViewModel.create(requireActivity().application)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ctnContent = view.findViewById(R.id.ctn_content)
        // Recycler View
        val rvTasks: RecyclerView = view.findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        listFromDataBase()
    }

    //Functions
    private fun listFromDataBase() {

        val listObserver = Observer <List<Task>>{ listTasks ->
            if (listTasks.isEmpty()){
                ctnContent.visibility = View.VISIBLE
            } else {
                ctnContent.visibility = View.GONE
            }
            adapter.submitList(listTasks)
        }
        viewModel.taskListLiveData.observe(this, listObserver)
    }
    private fun openTaskListDetail (task : Task){
        val intent = TaskDetailsActivity.start(requireContext(), task)
        requireActivity().startActivity(intent)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment Task_List.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance () = TaskListFragment()
            }
    }