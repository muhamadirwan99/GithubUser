package com.dicoding.picodiploma.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<User> = arrayListOf()

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray

    private var users = arrayListOf<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUser.setHasFixedSize(true)

        prepare()
        addItem()
        showRecyclerCardView()
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem(){
        for (position in dataName.indices){
            val user = User(
                    dataName[position],
                    dataUsername[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataCompany[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataAvatar.getResourceId(position, -1)
            )
            users.add(user)
        }
            list.addAll(users)
    }

    private fun showRecyclerCardView() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewUserAdapter(list)
        binding.rvUser.adapter = cardViewHeroAdapter

        cardViewHeroAdapter.setOnItemClickCallback(object : CardViewUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        val moveIntent = Intent(this@MainActivity, UserDetail::class.java)
        moveIntent.putExtra(UserDetail.EXTRA_USER, user)
        startActivity(moveIntent)
    }
}


