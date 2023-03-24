package com.danielriverolosa.core.domain.repository

import com.danielriverolosa.core.domain.entity.Product

interface ProductRepository {
    suspend fun getProductList(): List<Product>
}