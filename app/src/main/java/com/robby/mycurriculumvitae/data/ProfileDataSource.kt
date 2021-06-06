package com.robby.mycurriculumvitae.data

import androidx.lifecycle.LiveData
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity

interface ProfileDataSource {
    fun getProfile(): LiveData<ProfileEntity>
}