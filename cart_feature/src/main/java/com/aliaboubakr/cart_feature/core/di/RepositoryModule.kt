package com.aliaboubakr.cart_feature.core.di

import com.aliaboubakr.cart_feature.data.local.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.repository.CartRepositoryImpl
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Provides
    @Singleton
    abstract fun provideCartRepository(
        imageRepositoryImpl: CartRepositoryImpl,
        cartDao: CartDao
    ): CartRepository
}