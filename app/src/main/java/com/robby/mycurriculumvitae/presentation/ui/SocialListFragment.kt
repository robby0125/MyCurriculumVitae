package com.robby.mycurriculumvitae.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.robby.mycurriculumvitae.databinding.FragmentSocialListDialogBinding
import com.robby.mycurriculumvitae.databinding.FragmentSocialListItemBinding
import com.robby.mycurriculumvitae.domain.entities.SocialEntity
import com.robby.mycurriculumvitae.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SocialListFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSocialListDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSocialListDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel: MainViewModel by viewModel()
        viewModel.getProfile().observe(viewLifecycleOwner, {
            with(binding.list) {
                layoutManager = LinearLayoutManager(context)
                adapter = ItemAdapter(it.socials)
            }
        })
    }

    private inner class ViewHolder(private val itemBinding: FragmentSocialListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(social: SocialEntity) {
            view?.let {
                with(itemBinding) {
                    Glide.with(it.context)
                        .load(social.image)
                        .into(itemBinding.imgSocialLogo)

                    tvSocialName.text = social.title

                    root.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(social.url))
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private inner class ItemAdapter(private val socials: List<SocialEntity>) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(FragmentSocialListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(socials[position])
        }

        override fun getItemCount(): Int = socials.size
    }

    companion object {
        fun newInstance(): SocialListFragment =
            SocialListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}