package com.robby.mycurriculumvitae.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robby.mycurriculumvitae.R
import com.robby.mycurriculumvitae.domain.entities.HistoryEntity
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity
import com.robby.mycurriculumvitae.domain.entities.SkillEntity
import com.robby.mycurriculumvitae.domain.entities.SocialEntity

class ProfileDataSourceImpl : ProfileDataSource {
    override fun getProfile(): LiveData<ProfileEntity> {
        val profile = MutableLiveData<ProfileEntity>()
        profile.postValue(
            ProfileEntity(
                R.drawable.profile_pict,
                "Robby Alamsyah",
                "Informatics Engineering",
                "I'm just a noob developer, so that's why I keep learning.",
                provideSkills(),
                provideEducationalHistory(),
                provideAwards(),
                provideSocials()
            )
        )

        return profile
    }

    private fun provideSkills(): List<SkillEntity> = ArrayList<SkillEntity>().apply {
        add(SkillEntity(R.drawable.android_logo, "Android Native"))
        add(SkillEntity(R.drawable.flutter_logo, "Flutter"))
        add(SkillEntity(R.drawable.cocos2dx_logo, "Cocos2d-x"))
        add(SkillEntity(R.drawable.cocoscreator_logo, "Cocos Creator"))
        add(SkillEntity(R.drawable.unity_logo, "Unity"))
        add(SkillEntity(R.drawable.unreal_logo, "Unreal Engine"))
    }

    private fun provideEducationalHistory(): List<HistoryEntity> = ArrayList<HistoryEntity>().apply {
        add(HistoryEntity("Trunojoyo Madura University", "Informatics Engineering", "2019 - Present"))
        add(HistoryEntity("Vocational High School 1 Jember", "Multimedia", "2016 - 2019"))
    }

    private fun provideAwards(): List<HistoryEntity> = ArrayList<HistoryEntity>().apply {
        add(HistoryEntity("Google Certified", "Associate Android Developer", "2017 - 2020"))
        add(HistoryEntity("Dicoding Elite", "Mobile Apps and Games", "2016 - 2018"))
    }

    private fun provideSocials(): List<SocialEntity> = ArrayList<SocialEntity>().apply {
        add(SocialEntity(R.drawable.instagram_logo, "Instagram", "https://www.instagram.com/robbyalmsyh._/"))
        add(SocialEntity(R.drawable.facebook_logo, "Facebook", "https://www.facebook.com/robbyalamsyah2501/"))
    }
}