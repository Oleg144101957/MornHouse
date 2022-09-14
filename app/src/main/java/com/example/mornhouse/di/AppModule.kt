package com.example.mornhouse.di

import android.app.Application
import androidx.room.Room
import com.example.mornhouse.data.api.MainService
import com.example.mornhouse.data.api.MainService.Companion.BASE_URL
import com.example.mornhouse.data.db.HistoryDatabase
import com.example.mornhouse.data.repository.HistoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHistoryDatabase(app: Application) : HistoryDatabase {
        return Room.databaseBuilder(
            app,
            HistoryDatabase::class.java,
            HistoryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(db: HistoryDatabase, api: MainService): HistoryRepositoryImpl {
        return HistoryRepositoryImpl(db.historyDao, api)
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MainService = retrofit.create(MainService::class.java)
}