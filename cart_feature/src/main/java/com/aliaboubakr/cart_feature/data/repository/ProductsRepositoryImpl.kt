package com.aliaboubakr.cart_feature.data.repository

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.data.local.database.dao.ProductsDao
import com.aliaboubakr.cart_feature.data.mapper.ProductsMapper.toItemDtoList
import com.aliaboubakr.cart_feature.data.mapper.ProductsMapper.toProductEntity
import com.aliaboubakr.cart_feature.data.remote.datasource.RemoteDataSource
import com.aliaboubakr.cart_feature.domain.model.ProductItemDto
import com.aliaboubakr.cart_feature.domain.repository.ProductsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val productsDao: ProductsDao,
) : ProductsRepository {

    override suspend fun getProductsItemsByName(
        query: String?,
        showBought: Boolean,
        sortAsc: SortCriteria,
        isForceRefresh: Boolean,
    ): Flow<Resources<List<ProductItemDto>>> {
        forceRefreshItems(isForceRefresh)
        return flow { emit(Resources.Success(getFilteredItemsFromDB(query, showBought, sortAsc))) }
    }

    private suspend fun getFilteredItemsFromDB(
        query: String?,
        showBought: Boolean,
        sortAsc: SortCriteria,
    ): List<ProductItemDto> {

        if (query.isNullOrEmpty()) {
            return getAllItemsInDB(showBought, sortAsc)
        } else return getSearchedItemsInDB(query, showBought, sortAsc)
    }

    private suspend fun getSearchedItemsInDB(
        query: String,
        showBought: Boolean,
        sortAsc: SortCriteria,
    ): List<ProductItemDto> {
        return if (isAscending(sortAsc)) productsDao.getSearchItemsAsc(query, showBought)
            .toItemDtoList()
        else productsDao.getSearchItemsDes(query, showBought).toItemDtoList()
    }

    private fun isAscending(sortAsc: SortCriteria): Boolean {
        return when (sortAsc) {
            SortCriteria.SORT_ASC -> true
            else -> false
        }
    }

    //#done
    private suspend fun getAllItemsInDB(
        showBought: Boolean,
        sortAsc: SortCriteria,
    ): List<ProductItemDto> {
        return if (isAscending(sortAsc)) productsDao.getAllItemsAsc(showBought).toItemDtoList()
        else productsDao.getAllItemsDes(showBought).toItemDtoList()
    }

    //#done
    override suspend fun addCartItem(item: ProductItemDto) {
        insertCartItem(item)
    }

    //#done
    
    private suspend fun deleteAllItems() {
        productsDao.delete()
    }

    //#done


    //#done
    private suspend fun insertProductsItems(items: List<ProductItemDto>) {
        items.map {
            productsDao.insert(it.toProductEntity())
        }
    }

    //#done
    private suspend fun insertCartItem(item: ProductItemDto) {
        productsDao.insert(item.toProductEntity())
    }

    //#done
    private suspend fun deleteCartItems() {
        productsDao.delete()
    }

    //#done
    private suspend fun deleteCartItemFromDB(itemId: Long) {
        productsDao.delete(itemId)
    }

    //#done
    private suspend fun forceRefreshItems(isForceRefresh: Boolean) {
        if (isForceRefresh) {
            coroutineScope {
                launch { deleteCartItems() }.join()
                launch {
                    val data = async { remoteDataSource.getRemoteCartItemList().data }.await()
                    data?.let { insertProductsItems(it) }
                }.join()
            }
        }
    }
}