package com.robby.mycurriculumvitae.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity
import com.robby.mycurriculumvitae.domain.ProfileUseCase

class MainViewModel(private val useCase: ProfileUseCase) : ViewModel() {
    fun getProfile(): LiveData<ProfileEntity> = useCase.getProfile()
}