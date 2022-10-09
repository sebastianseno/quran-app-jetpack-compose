package com.compose.quran.di

import android.util.Log
import com.compose.quran.BuildConfig
import com.compose.quran.rest.services.SurahServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val timeOut: Int by lazy {
        60
    }
    private val jsonChecker by lazy {
        object : Converter.Factory() {
            override fun responseBodyConverter(
                type: Type,
                annotations: Array<Annotation>,
                retrofit: Retrofit
            ): Converter<ResponseBody, *> {
                return Converter<ResponseBody, Any> { responseBody ->
                    val delegate =
                        retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
                    try {
                        delegate.convert(responseBody)
                    } catch (error: Exception) {
                        error.message?.let { Log.e("quotes ", it) }
                        throw IOException("Terjadi kesalahan pada server")
                    }
                }
            }
        }
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.QURAN_URL)
            .addConverterFactory(jsonChecker)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    }

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        return builder.build()
    }


    @Provides
    @Singleton
    fun provideSurahServices(retrofit: Retrofit): SurahServices {
        return retrofit.create(SurahServices::class.java)
    }


}