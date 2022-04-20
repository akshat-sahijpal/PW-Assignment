package com.akshatsahijpal.phywallassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akshatsahijpal.phywallassignment.data.TeachersData
import com.akshatsahijpal.phywallassignment.databinding.TeacherCardBinding
import com.bumptech.glide.Glide

class PagingAdapter :
    PagingDataAdapter<TeachersData.TeachersDataItem, PagingAdapter.Holder>(compareList) {
    companion object {
        val compareList = object : DiffUtil.ItemCallback<TeachersData.TeachersDataItem>() {
            override fun areItemsTheSame(
                oldItem: TeachersData.TeachersDataItem,
                newItem: TeachersData.TeachersDataItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: TeachersData.TeachersDataItem,
                newItem: TeachersData.TeachersDataItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    inner class Holder(
        private var _bind: TeacherCardBinding
    ) : RecyclerView.ViewHolder(_bind.root) {
        fun connect(data: TeachersData.TeachersDataItem) {
            _bind.apply {
                Glide.with(_bind.root).load(data.profileImage).centerCrop().into(profilePicture)
                teacherName.text = data.name
                subjectName.text = data.subjects[0]
                instituteName.text = data.qualification[0]
            }
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val dataSet: TeachersData.TeachersDataItem? = getItem(position)
        if (dataSet != null) {
            holder.connect(dataSet)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val viewer = TeacherCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(viewer)
    }
}