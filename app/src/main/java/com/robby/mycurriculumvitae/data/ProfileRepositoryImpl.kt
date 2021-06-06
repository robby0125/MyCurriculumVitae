package com.robby.mycurriculumvitae.data

import androidx.lifecycle.LiveData
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity
import com.robby.mycurriculumvitae.domain.ProfileRepository

class ProfileRepositoryImpl(private val dataSource: ProfileDataSource) : ProfileRepository {
    override fun getProfile(): LiveData<ProfileEntity> = dataSource.getProfile()
}