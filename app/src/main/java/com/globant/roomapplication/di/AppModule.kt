package com.globant.roomapplication.di

import android.content.Context
import androidx.room.Room
import com.globant.shared.data.datasource.local.SchoolDao
import com.globant.roomapplication.db.SchoolDatabase
import com.globant.shared.data.datasource.SchoolDataSourceImpl
import com.globant.shared.data.mapper.SchoolAndDirectorListMapper
import com.globant.shared.data.mapper.SchoolWithStudentsListMapper
import com.globant.shared.data.mapper.StudentWithSubjectsListMapper
import com.globant.shared.data.mapper.SubjectsWithStudentsListMapper
import com.globant.shared.data.repository.SchoolRepositoryImpl
import com.globant.shared.di.IoDispatcher
import com.globant.shared.domain.datasource.SchoolDataSource
import com.globant.shared.domain.repository.SchoolRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSchoolDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        SchoolDatabase::class.java,
        "school_db"
    ).build()

    @Singleton
    @Provides
    fun provideSchoolDao(db: SchoolDatabase) = db.schoolDao


    @Singleton
    @Provides
    fun provideSchoolDataSource(
        dao: SchoolDao,
        schoolAndDirectorMapper: SchoolAndDirectorListMapper,
        schoolWithStudentsMapper: SchoolWithStudentsListMapper,
        subjectsWithStudentListMapper: SubjectsWithStudentsListMapper,
        studentWithSubjectsListMapper: StudentWithSubjectsListMapper,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): SchoolDataSource =
        SchoolDataSourceImpl(
            dao,
            schoolAndDirectorMapper,
            schoolWithStudentsMapper,
            subjectsWithStudentListMapper,
            studentWithSubjectsListMapper,
            ioDispatcher
        )

    @Singleton
    @Provides
    fun provideSchoolRepository(
        schoolDataSource: SchoolDataSource,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): SchoolRepository =
        SchoolRepositoryImpl(
            schoolDataSource,
            ioDispatcher
        )
}