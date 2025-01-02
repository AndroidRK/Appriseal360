package com.rutvik.appraisal360.di

import android.content.Context
import androidx.room.Room
import com.rutvik.appraisal360.database.AppDatabase
import com.rutvik.appraisal360.database.ManagerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {



   /* @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase{
           return Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
    }*/

    @Provides
    @Singleton
    fun provideManagerDao(@ApplicationContext app:Context):ManagerDao{
        return  AppDatabase.getDatabase(app).getManagerDao()
    }


}