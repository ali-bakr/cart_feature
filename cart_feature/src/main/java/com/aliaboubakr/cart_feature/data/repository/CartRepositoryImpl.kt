package com.aliaboubakr.cart_feature.data.repository

import com.aliaboubakr.cart_feature.core.util.Resources
import com.aliaboubakr.cart_feature.data.enum.SortCriteria
import com.aliaboubakr.cart_feature.data.local.database.dao.CartDao
import com.aliaboubakr.cart_feature.data.mapper.CartMapper.toEntity
import com.aliaboubakr.cart_feature.data.mapper.CartMapper.toItemDtoList
import com.aliaboubakr.cart_feature.data.remote.datasource.RemoteDataSource
import com.aliaboubakr.cart_feature.domain.model.CartItemDto
import com.aliaboubakr.cart_feature.domain.repository.CartRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cartDao: CartDao,
) : CartRepository {
    /**
    override fun getImages(text: String): Flow<Resources<List<CartItem>>> {
    return flow {
    emit(Resources.Loading(true))
    val remoteList = try {
    imageAPi.getImages(text)
    } catch (e: IOException) {
    e.printStackTrace()
    emit(Resources.Error("Could not load data"))
    null
    } catch (e: HttpException) {
    e.printStackTrace()
    emit(Resources.Error("Could not load data"))
    null
    }

    if (remoteList == null) {
    emit(Resources.Loading(false))
    }
    remoteList.let { listing ->
    emit(Resources.Success(data = listing?.images?.map { it.toImage() }))
    emit(Resources.Loading(false))
    }
    }
    }

     **/


    override suspend fun getCartItemsByName(
        query: String?,
        showBought: Boolean,
        sortAsc: SortCriteria,
        isForceRefresh: Boolean,
    ): Flow<Resources<List<CartItemDto>>> {
        forceRefreshItems(isForceRefresh)
        return flow { emit(Resources.Success(getFilteredItemsFromDB(query, showBought, sortAsc))) }
    }

    private suspend fun getFilteredItemsFromDB(
        query: String?,
        showBought: Boolean,
        sortAsc: SortCriteria,
    ): List<CartItemDto> {

        if (query.isNullOrEmpty()) {
            return getAllItemsInDB(showBought, sortAsc)
        } else return getSearchedItemsInDB(query, showBought, sortAsc)
    }

    private suspend fun getSearchedItemsInDB(
        query: String,
        showBought: Boolean,
        sortAsc: SortCriteria,
    ): List<CartItemDto> {
        return if (isAscending(sortAsc)) cartDao.getSearchItemsAsc(query, showBought)
            .toItemDtoList()
        else cartDao.getSearchItemsDes(query, showBought).toItemDtoList()
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
    ): List<CartItemDto> {
        return if (isAscending(sortAsc)) cartDao.getAllItemsAsc(showBought).toItemDtoList()
        else cartDao.getAllItemsDes(showBought).toItemDtoList()
    }

    //#done
    override suspend fun addCartItem(item: CartItemDto) {
        insertCartItem(item)
    }

    //#done
    override suspend fun updateCartItem(item: CartItemDto) {
        updateCartItemInDB(item)
    }

    //#done
    override suspend fun deleteCartItem(itemId: Long) {
        deleteCartItemFromDB(itemId)
    }

    override suspend fun deleteAllCartItems() {
        deleteAllItems()
    }

    override suspend fun syncCart() {
        TODO("Not yet implemented")
    }


    //#done
    private suspend fun deleteAllItems() {
        cartDao.delete()
    }

    //#done


    //#done
    private suspend fun insertCartItems(items: List<CartItemDto>) {
        items.map {
            cartDao.insert(it.toEntity())
        }
    }

    //#done
    private suspend fun insertCartItem(item: CartItemDto) {
        cartDao.insert(item.toEntity())
    }

    //#done
    private suspend fun deleteCartItems() {
        cartDao.delete()
    }

    //#done
    private suspend fun updateCartItemInDB(cartItemDto: CartItemDto) {
        cartDao.update(cartItemDto.toEntity())
    }

    //#done
    private suspend fun deleteCartItemFromDB(itemId: Long) {
        cartDao.delete(itemId)
    }

    //#done
    private suspend fun forceRefreshItems(isForceRefresh: Boolean) {
        if (isForceRefresh) {
            coroutineScope {
                launch { deleteCartItems() }.join()
                launch {
                    val data = async { remoteDataSource.getRemoteCartItemList().data }.await()
                    data?.let { insertCartItems(it) }
                }.join()
            }
        }
    }
}