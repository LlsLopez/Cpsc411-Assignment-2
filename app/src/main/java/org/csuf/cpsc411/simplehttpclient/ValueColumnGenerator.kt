package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.GREEN)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5
        var value = EditText(ctx)
        value.id = R.id.first_name
        value.setHint("Enter First Name")
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)
        value = EditText(ctx)
        value.id = R.id.last_name
        value.setHint("Enter Last Name")
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)
        value = EditText(ctx)
        value.id = R.id.ssn
        value.setHint("Enter SSN")
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}