package com.danielriverolosa.home.di

import com.danielriverolosa.home.factory.HomeNavigationFactory
import com.danielriverolosa.navigation.NavigationFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NavigationFactoryModule {
    @Singleton
    @Binds
    @IntoSet
    fun bindComposeNavigationFactory(factory: HomeNavigationFactory): NavigationFactory
}