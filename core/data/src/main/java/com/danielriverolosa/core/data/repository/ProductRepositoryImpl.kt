package com.danielriverolosa.core.data.repository

import com.danielriverolosa.core.data.datasource.api.product.ProductApiService
import com.danielriverolosa.core.data.datasource.api.product.model.ProductItemResponse
import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ProductApiService
) : ProductRepository {
    override suspend fun getProductList(): List<Product> {
        return apiService.getProductList().map()
    }

    private fun List<ProductItemResponse>.map() = map {
        Product(
            it.id,
            it.title,
            it.price
        )
    }
}