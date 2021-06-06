package com.robby.mycurriculumvitae.domain

import androidx.lifecycle.LiveData
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity

interface ProfileRepository {
    fun getProfile(): LiveData<ProfileEntity>
}