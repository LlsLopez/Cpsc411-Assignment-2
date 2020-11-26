package org.csuf.cpsc411.simplehttpclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UIEditorTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ClaimService(this).addClaim(Claim("id1", "claim1", "date1", 1))
        setContentView(R.layout.hw2)
    }
}