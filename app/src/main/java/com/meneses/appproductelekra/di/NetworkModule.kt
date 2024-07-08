package com.meneses.appproductelekra.di

import com.meneses.appproductelekra.data.network.ProductClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //http://alb-dev-ekt-875108740.us-east-1.elb.amazonaws.com/apps/moviles/caso-practico/plp
    @Singleton
    @Provides
    fun provideRetorfit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://alb-dev-ekt-875108740.us-east-1.elb.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideProductApiCLient(retrofit: Retrofit): ProductClient {
        return retrofit.create(ProductClient::class.java)
    }

}