package com.dicoding.picodiploma.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.picodiploma.githubuser.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityUserDetailBinding

    private var title: String = "Detail User"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra(EXTRA_USER) as User

        val imgAvatar: ImageView = binding.imgItemAvatar
        val tvName: TextView = binding.tvItemName
        val tvUsername: TextView = binding.tvItemUsername
        val tvLocation: TextView = binding.tvLocation
        val tvRepository: TextView = binding.tvRepository
        val tvCompany: TextView = binding.tvCompany
        val tvFollowers: TextView = binding.tvFollowers
        val tvFollowing: TextView = binding.tvFollowing


        imgAvatar.setImageResource(user.avatar)
        tvName.text = user.name
        tvUsername.text = user.username
        tvLocation.text = user.location
        tvRepository.text = user.repository
        tvCompany.text = user.company
        tvFollowers.text = user.followers
        tvFollowing.text = user.following

        setActionBarTitle(title)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }
}


