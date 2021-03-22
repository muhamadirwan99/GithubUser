package com.dicoding.picodiploma.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.githubuser.databinding.ItemRowUserBinding

class CardViewUserAdapter (private val listUser: ArrayList<User>): RecyclerView.Adapter<CardViewUserAdapter.CardViewHolder> (){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions()).override(350,550)
                .into(holder.imgAvatar)

        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.tvFollowers.text = user.followers
        holder.tvFollowing.text = user.following

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowUserBinding.bind(itemView)

        val imgAvatar: ImageView = binding.imgItemAvatar
        val tvName: TextView = binding.tvItemName
        val tvUsername: TextView = binding.tvItemUsername
        val tvFollowers: TextView = binding.tvFollowers
        val tvFollowing: TextView = binding.tvFollowing
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

}