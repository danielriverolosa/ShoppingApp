package com.danielriverolosa.core.data.datasource.api.product

import com.danielriverolosa.core.data.datasource.api.product.model.ProductItemResponse
import retrofit2.http.GET

interface ProductApiService {

    @GET("products/")
    suspend fun getProductList(): List<ProductItemResponse>
}