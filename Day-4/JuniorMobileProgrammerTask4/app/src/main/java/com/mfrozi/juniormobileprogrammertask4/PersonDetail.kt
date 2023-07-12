package com.mfrozi.juniormobileprogrammertask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mfrozi.juniormobileprogrammertask4.databinding.ActivityPersonDetailBinding
import com.mfrozi.juniormobileprogrammertask4.models.Person

class PersonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPersonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }
    fun getData(){
        val data = intent.getSerializableExtra("person") as Person
        Glide.with(this)
            .load(data.profileUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.ivProfilPicturePeoplePersonDetail)
        binding.tvNamePersonDetail.text = data.name
        binding.tvEmailPersonDetail.text = data.email
        binding.tvJurusanPersonDetail.text = data.jurusan
        binding.tvSemesterPersonDetail.text = data.semester.toString()
    }
}