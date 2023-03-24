package com.danielriverolosa.core.data.di

import com.danielriverolosa.core.data.datasource.api.ApiClientGenerator
import com.danielriverolosa.core.data.datasource.api.product.ProductApiService
import com.danielriverolosa.core.data.repository.ProductRepositoryImpl
import com.danielriverolosa.core.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideProductRepository(clientGenerator: ApiClientGenerator): ProductRepository =
        ProductRepositoryImpl(clientGenerator.generate(ProductApiService::class))
}