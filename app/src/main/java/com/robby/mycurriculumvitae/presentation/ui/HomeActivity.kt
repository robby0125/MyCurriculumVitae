package com.robby.mycurriculumvitae.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.robby.mycurriculumvitae.R
import com.robby.mycurriculumvitae.databinding.ActivityHomeBinding
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity
import com.robby.mycurriculumvitae.presentation.adapter.SkillAdapter
import com.robby.mycurriculumvitae.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Personal CV"

        val mainViewModel: MainViewModel by viewModel()
        mainViewModel.getProfile().observe(this, {
            provideProfile(it)
        })
    }

    private fun provideProfile(profile: ProfileEntity) {
        Glide.with(this)
            .load(profile.image)
            .into(binding.imgProfile)

        binding.tvName.text = profile.name
        binding.tvDepartment.text = profile.department
        binding.tvAbout.text = profile.about

        val adapter = SkillAdapter()
        adapter.setSkills(profile.skills)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        with(binding.rvSkill) {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            this.adapter = adapter
        }

        binding.btnHistory.setOnClickListener(this)
        binding.btnSocial.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_history -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_social -> {
                val socialListFragment = SocialListFragment.newInstance()
                socialListFragment.show(supportFragmentManager, SocialListFragment::class.java.simpleName)
            }
        }
    }
}