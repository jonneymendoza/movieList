package com.richards.jonathan.movielist.data.network

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.movielist.data.Resource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class CallHandler<DATA : Any> {
//    lateinit var client: Deferred<Response<DATA>>

    fun makeCall(client: Deferred<Response<DATA>>): MutableLiveData<Resource<DATA>> {
        val result = MutableLiveData<Resource<DATA>>()
        result.value = Resource.loading(null)

        GlobalScope.launch {
            try {

                val response = client.await()
                if (response.isSuccessful) {
                    val data = response.body() as DATA
                    result.postValue(Resource.success(data))
                }


            } catch (e: Exception) {
                result.postValue(Resource.error(e.toString(), null))
            }
        }
        return result

    }
}
