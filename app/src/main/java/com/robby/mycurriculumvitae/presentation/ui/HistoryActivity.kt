package com.robby.mycurriculumvitae.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.robby.mycurriculumvitae.databinding.ActivityHistoryBinding
import com.robby.mycurriculumvitae.domain.entities.ProfileEntity
import com.robby.mycurriculumvitae.presentation.adapter.HistoryAdapter
import com.robby.mycurriculumvitae.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "My History"

        val viewModel: MainViewModel by viewModel()

        viewModel.getProfile().observe(this, {
            provideHistory(it)
        })
    }

    private fun provideHistory(profile: ProfileEntity) {
        val educationalAdapter = HistoryAdapter()
        educationalAdapter.setHistoryList(profile.educationalHistory)

        with(binding.rvEducational) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = educationalAdapter
        }

        val awardsAdapter = HistoryAdapter()
        awardsAdapter.setHistoryList(profile.awards)

        with(binding.rvAwards) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = awardsAdapter
        }
    }
}