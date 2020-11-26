package org.csuf.cpsc411.simplehttpclient

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SummaryScreenActivity : CustomActivity() {

    lateinit var root : LinearLayout
    lateinit var summaryView : ListView
    lateinit var customAdapter : CustomAdapter
    // lateinit var pService : PersonService

    fun refreshScreen() {
        customAdapter.notifyDataSetChanged()
    }

    fun deletePersons() {
        for (pObj in pService.personList) {
            if (pObj.toBeDeleted) {
                // Delete the record
                Log.d("SummaryView", "Invoke PersonService.deleteObj method to delete ${pObj.firstName}")

            }
            //customAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = LinearLayout(this)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        root.layoutParams = lParams
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(Color.MAGENTA)
        //
        summaryView = ListView(this)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        summaryView.setBackgroundColor(Color.YELLOW)
        root.addView(summaryView, nbParams)

        setContentView(root)
        //
        // pService = PersonService(this)
        pService = PersonService.getInstance(this)
        customAdapter = CustomAdapter(pService)
        summaryView.adapter = customAdapter
        customAdapter.updateData()
        //
        summaryView.setOnItemClickListener{p, v, pos, id ->
            // Navigate to CustomActivity
            val intent = Intent(this, CustomActivity::class.java)
            intent.putExtra("ElementId", pos)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var item : MenuItem? = null
        //item = menu?.add(0, 5, 0, "Delete")
        //item?.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        item = menu?.add(0, 5, 0, "Edit")
        item?.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        item = menu?.add(0, 6, 0, "Add")
        item?.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 5) {
            Log.d("SummaryView", "Edit menu was clicked. ")
            if (customAdapter.editMode == false) {
                customAdapter.editMode = true
                item.setTitle("Delete")
                //
                customAdapter.notifyDataSetChanged()
            } else {
                //
                deletePersons()
                customAdapter.editMode = false
                item.setTitle("Edit")
                //
                customAdapter.notifyDataSetChanged()
            }
        }
        if (item.itemId == 6) {
            Log.d("SummaryView", "ADD menu was clicked. ")
            // Navigate to the Detailed Activity
            // Tell the new activity this is a ADD person scenario

        }
        return super.onOptionsItemSelected(item)
    }
}