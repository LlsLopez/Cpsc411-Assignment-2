package org.csuf.cpsc411.simplehttpclient

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter(val pService : PersonService) : BaseAdapter() {

    var editMode : Boolean = false

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val pObj = pService.personList[position]
        val root = LinearLayout(parent?.context)
        val rParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        root.setLayoutParams(rParams)
        root.orientation = LinearLayout.HORIZONTAL

        val chkbx = CheckBox(parent?.context)
        val cbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        chkbx.setOnClickListener{
            if ((it as CheckBox).isChecked) pService.personList[position].toBeDeleted = true
            else pService.personList[position].toBeDeleted = false
        }
        //
        if (editMode) chkbx.visibility = View.VISIBLE
        else chkbx.visibility = View.GONE

        root.addView(chkbx, cbParams)
        val label = "${pObj.firstName} ${pObj.lastName}"
        val lblView = TextView(parent?.context)
        lblView.text = label
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        root.addView(lblView, lbParams)

        return root
    }

    override fun getItem(position: Int): Any {
        return pService.personList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return pService.personList.size
    }

    fun updateData() {
        pService.getAll()
    }

}