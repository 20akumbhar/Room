package com.ajinkya.room.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.ajinkya.room.R
import com.ajinkya.room.TaskAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.add_list.view.*
import kotlinx.android.synthetic.main.add_list_dialog.view.*
import kotlinx.android.synthetic.main.add_task.view.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.task_fragment.*

class TaskFragment : Fragment(R.layout.task_fragment) {
    private lateinit var viewModel: TaskViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        rv_main.setHasFixedSize(true)
        val adapter = TaskAdapter()
        rv_main.adapter = adapter
        // val alertdialog:AlertDialog.Builder()

        val bottomSheetDialog = BottomSheetDialog(context!!)
        val view = layoutInflater.inflate(R.layout.add_task, null)
        bottomSheetDialog.setContentView(view)
        ib_add_task.setOnClickListener {
            bottomSheetDialog.show()
        }
        view.btn_add_task.setOnClickListener {
            Toast.makeText(context, view.et_add_task.text.toString(), Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        val bottomSheetDialog2 = BottomSheetDialog(context!!)
        val view2 = layoutInflater.inflate(R.layout.add_list, null)
        bottomSheetDialog2.setContentView(view2)
        view2.rv_list_group.adapter = adapter
        ib_lists.setOnClickListener {
            bottomSheetDialog2.show()
        }
        view2.ll_add_list_item.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.add_list_dialog, null)
            val addListAlertDialog = AlertDialog.Builder(context!!,R.style.dialog).setView(dialogView)
                .setTitle("Add New List")
                .setCancelable(true)
                .create()
            addListAlertDialog.show()
            dialogView.btn_add_list.setOnClickListener {
                val list = dialogView.et_add_list_item.text.toString()
                if (list.trim() != "") {
                    Toast.makeText(context, "$list will be added", Toast.LENGTH_SHORT).show()
                }
                addListAlertDialog.dismiss()
            }
        }
    }

}
