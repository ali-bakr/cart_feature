package com.aliaboubakr.cart_feature.core.di

import android.content.Context
import androidx.room.Room
import com.aliaboubakr.cart_feature.data.constants.DatabaseConstants.DATABASE_NAME
import com.aliaboubakr.cart_feature.data.local.database.CartDatabase
import com.aliaboubakr.cart_feature.data.local.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.remote.ShoppingAPi
import com.aliaboubakr.cart_feature.data.remote.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCartApi(): ShoppingAPi {
        return Retrofit.Builder()
            .baseUrl("https://lexica.art/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }).build()
            )
            .build()
            .create(ShoppingAPi::class.java)
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context):CartDatabase{
        return Room.databaseBuilder(context,CartDatabase::class.java,DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(shoppingAPi: ShoppingAPi): RemoteDataSource {
        return RemoteDataSource(shoppingAPi)
    }

    @Provides
    @Singleton
    fun provideCartDao(cartDatabase: CartDatabase): CartDao {
        return cartDatabase.cartDao
    }

}