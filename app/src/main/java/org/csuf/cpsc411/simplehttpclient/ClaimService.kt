package org.csuf.cpsc411.simplehttpclient

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type
class ClaimService(val ctx : Context) {


    var claimList : MutableList<Person> = mutableListOf()
    var currentIndx : Int = 0

    inner class AddServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String()
                Log.d("Claim Service", "Service Response: ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            TODO("Not yet implemented")
        }

    }



    fun addClaim(cObj : Claim)
    {
        val client = AsyncHttpClient()
        val requestUrl = "http://0.0.0.0:8010/ClaimService/add"

        val jsonStr = Gson().toJson(cObj)

        val entity = StringEntity(jsonStr)

        client.post(ctx,requestUrl,entity,"application/Json",AddServiceRespHandler())
    }
}