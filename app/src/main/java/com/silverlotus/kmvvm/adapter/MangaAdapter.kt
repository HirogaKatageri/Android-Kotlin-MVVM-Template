package com.silverlotus.kmvvm.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silverlotus.kmvvm.R
import com.silverlotus.kmvvm.room.entity.MangaEntity
import kotlinx.android.synthetic.main.item_manga.view.*

/**
 * Created by Gian Patrick Quintana on 2/24/2018.
 */
class MangaAdapter : ListAdapter<MangaEntity, MangaAdapter.MangaViewHolder>(MangaItemCallback()) {

    private class MangaItemCallback : DiffUtil.ItemCallback<MangaEntity>() {

        override fun areItemsTheSame(oldItem: MangaEntity?, newItem: MangaEntity?): Boolean = oldItem?.id == newItem?.id
        
        override fun areContentsTheSame(oldItem: MangaEntity?, newItem: MangaEntity?): Boolean = oldItem?.title == newItem?.title
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        val manga = getItem(position)
        if (manga != null)
            holder.bind(manga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder =
            MangaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_manga, parent, false))

    inner class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(manga: MangaEntity?) = with(itemView) {
            textTitle.text = manga?.title
        }
    }

}