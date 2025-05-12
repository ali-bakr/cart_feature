package com.aliaboubakr.cart_feature.core.di

import com.aliaboubakr.cart_feature.data.local.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.local.database.dao.ProductsDao
import com.aliaboubakr.cart_feature.data.local.database.entity.ProductEntity
import com.aliaboubakr.cart_feature.data.remote.datasource.RemoteDataSource
import com.aliaboubakr.cart_feature.data.repository.CartRepositoryImpl
import com.aliaboubakr.cart_feature.data.repository.ProductsRepositoryImpl
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import com.aliaboubakr.cart_feature.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  RepositoryModule {
    @Provides
    @Singleton
    fun provideCartRepository(
        remoteDataSource: RemoteDataSource,
        cartDao: CartDao
    ): CartRepository {
        return CartRepositoryImpl(remoteDataSource,cartDao)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        remoteDataSource: RemoteDataSource,
        productDao: ProductsDao
    ): ProductsRepository {
        return ProductsRepositoryImpl(remoteDataSource,productDao)
    }
}