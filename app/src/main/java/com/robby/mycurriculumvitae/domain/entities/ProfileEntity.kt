package com.robby.mycurriculumvitae.domain.entities

data class ProfileEntity(
    val image: Int,
    val name: String,
    val department: String,
    val about: String,
    val skills: List<SkillEntity>,
    val educationalHistory: List<HistoryEntity>,
    val awards: List<HistoryEntity>,
    val socials: List<SocialEntity>
)
