package com.robby.mycurriculumvitae.domain

import androidx.lifecycle.LiveData
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity

interface ProfileUseCase {
    fun getProfile(): LiveData<ProfileEntity>
}