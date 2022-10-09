package com.compose.quran.di

import com.compose.quran.domain.repositories.SurahRepository
import com.compose.quran.domain.usecase.SurahUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule {
//
//    @Binds
//    @Singleton
//    abstract fun bindSurahRepository(
//        surahRepositoryImpl: SurahUseCase
//    ): SurahRepository
//
//}