package com.example.dailynewsapp.utils


import android.util.Log
import org.json.JSONObject
import retrofit2.Response


abstract class SafeApiRequest {
    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {

        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseError = response.errorBody()?.string()
            val message = StringBuilder()
            responseError?.let {
                try {
                    message.append(JSONObject(it).getString("error"))
                } catch (e: Exception) {

                }
            }
            Log.d("TAG", "safeApiRequest: ${message.toString()}")
            throw Exception(message.toString())
        }
    }
}