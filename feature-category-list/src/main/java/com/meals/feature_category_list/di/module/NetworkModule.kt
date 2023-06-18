package com.meals.feature_category_list.di.module

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.meals.feature_category_list.BuildConfig
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol

val networkModule = module {
    single(qualifier = StringQualifier("BASE_URL")) { provideBaseUrl() }
    single { ktorHttpClient }

}


fun provideBaseUrl(): String {

    return BuildConfig.BASE_URL
}



private const val TIME_OUT = 60_000

private val ktorHttpClient = HttpClient(Android) {

    install(JsonFeature) {
        serializer =  GsonSerializer()

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }

        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = BuildConfig.BASE_URL
        }
    }
}