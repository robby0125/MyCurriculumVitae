package com.robby.mycurriculumvitae.domain

import androidx.lifecycle.LiveData
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity

class ProfileInteractor(private val repository: ProfileRepository) : ProfileUseCase {
    override fun getProfile(): LiveData<ProfileEntity> = repository.getProfile()
}