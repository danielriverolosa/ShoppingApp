package com.danielriverolosa.core.data.datasource.api.product.model

import kotlinx.serialization.Serializable

@Serializable
class ProductItemResponse(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val image: String,
    val rating: ProductRatingResponse
)

@Serializable
class ProductRatingResponse(
    val rate: Double,
    val count: Int
)