package com.robby.mycurriculumvitae.di

import android.app.Application
import com.robby.mycurriculumvitae.data.ProfileDataSource
import com.robby.mycurriculumvitae.data.ProfileDataSourceImpl
import com.robby.mycurriculumvitae.data.ProfileRepositoryImpl
import com.robby.mycurriculumvitae.domain.ProfileInteractor
import com.robby.mycurriculumvitae.domain.ProfileRepository
import com.robby.mycurriculumvitae.domain.ProfileUseCase
import com.robby.mycurriculumvitae.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    private val appModule = module {
        single<ProfileDataSource> { ProfileDataSourceImpl() }
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
        single<ProfileUseCase> { ProfileInteractor(get()) }

        viewModel { MainViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}