package com.example.mbits.di

import android.content.Context
import com.example.mbits.util.PrefStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesPrefStore(@ApplicationContext context: Context) = PrefStore(context)

}