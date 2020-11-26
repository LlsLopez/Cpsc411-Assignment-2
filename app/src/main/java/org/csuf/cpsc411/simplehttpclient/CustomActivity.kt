package org.csuf.cpsc411.simplehttpclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText

open class CustomActivity : AppCompatActivity() {
   // lateinit var pList : MutableList<Person>
    //lateinit var pService : PersonService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ClaimService(this).addClaim(Claim("id1", "claim1", "date1", 1))
        setContentView(R.layout.hw2)
    }


}

/*
fun refreshScreen(pObj : Person) {
//
Log.d("Person Service", "Refreshing the Screen. ")
val firstNameView : EditText = findViewById(R.id.first_name)
val lastNameView : EditText = findViewById(R.id.last_name)
val ssnView : EditText = findViewById(R.id.ssn)
//
firstNameView.setText(pObj.firstName)
firstNameView.setEnabled(false)
lastNameView.setText(pObj.lastName)
ssnView.setText(pObj.ssn)
// Enable/disable the button
val nBtn : Button = findViewById(R.id.next_btn)
nBtn.setEnabled(!pService.isLastObject())
}

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
//val fldRowGenerator = FieldValueViewGenerator(this, "SSN")
//val colGenerator = LableColumnGenerator(this)
//val colView = colGenerator.generate()
val fldRowGenerator = ObjDetailScreenGenerator(this)
val colView = fldRowGenerator.generate()
setContentView(colView)
//
val bView : Button = findViewById(R.id.next_btn)
//
bView.setOnClickListener{
    // get the next Person object
    val pObj = pService.next()
    refreshScreen(pObj)
}
//
val pos = intent.getIntExtra("ElementId", 0)
Log.d("Detailed Activity ", "Display ${pos} Person object")
pService = PersonService.getInstance(this)
if (pService.personList.count() != 0) {
    val pObj = pService.fetchAt(pos)
    refreshScreen(pObj)
} */

//pService.getAll()

//setContentView(R.layout.main_activity)