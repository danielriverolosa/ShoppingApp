package com.danielriverolosa.core.domain.usecase.product

import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.domain.repository.ProductRepository
import com.danielriverolosa.core.domain.usecase.UseCase
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: ProductRepository
) : UseCase<List<Product>, Unit>() {

    override suspend fun run(params: Unit) =
        repository.getProductList()
}