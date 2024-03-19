package ca.burchill.chuck.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL =  "https://api.chucknorris.io/jokes/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface ChuckApiService {

    @GET("random")
    suspend fun getJoke() : ChuckJoke

}

object ChuckApi {
    val retrofitService : ChuckApiService by lazy{
        retrofit.create(ChuckApiService::class.java)
    }


}