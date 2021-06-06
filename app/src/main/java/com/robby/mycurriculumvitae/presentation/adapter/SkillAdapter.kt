package com.robby.mycurriculumvitae.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.robby.mycurriculumvitae.databinding.SkillItemBinding
import com.robby.mycurriculumvitae.domain.entities.SkillEntity

class SkillAdapter : RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {
    private val skills = ArrayList<SkillEntity>()

    fun setSkills(skills: List<SkillEntity>) {
        this.skills.clear()
        this.skills.addAll(skills)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val binding = SkillItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.bind(skills[position])
    }

    override fun getItemCount(): Int = skills.size

    class SkillViewHolder(private val binding: SkillItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(skill: SkillEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(skill.image)
                    .into(imgSkill)

                tvSkill.text = skill.title
            }
        }
    }
}