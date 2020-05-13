package com.ajinkya.room

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ajinkya.room.services.Manager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_list.view.*
import kotlinx.android.synthetic.main.add_list_dialog.view.*
import kotlinx.android.synthetic.main.add_task.view.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sortItems = arrayOf("Time", "Name")
        val checkedSortItem = Manager.getSortChoice(this)
        val showItems = arrayOf("All", "Completed", "InCompleted")
        val checkedShowItem = Manager.getShowChoice(this)
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_sort -> {
                val alertdialog = AlertDialog.Builder(this, R.style.dialog)
                    .setTitle("Sort by")
                    .setSingleChoiceItems(sortItems, checkedSortItem) { dialog, which ->
                        Manager.saveSortChoice(this, which)
                        Toast.makeText(this, sortItems[which], Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }.create()
                alertdialog.show()
                return true
            }

            R.id.action_show -> {
                val alertdialog = AlertDialog.Builder(this, R.style.dialog)
                    .setTitle("Show only")
                    .setSingleChoiceItems(showItems, checkedShowItem) { dialog, which ->
                        Manager.saveShowChoice(this, which)
                        Toast.makeText(this, sortItems[which], Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }.create()
                alertdialog.show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
