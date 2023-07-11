package com.mfrozi.juniormobileprogrammertask3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mfrozi.juniormobileprogrammertask3.models.Person

class PersonDetail : AppCompatActivity() {
    private lateinit var profile : ImageView
    private lateinit var name : TextView
    private lateinit var email : TextView
    private lateinit var jurusan : TextView
    private lateinit var semester : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)

        initView()
        getData()

    }
    fun initView(){
        profile = findViewById(R.id.iv_profil_picture_people_person_detail)
        name = findViewById(R.id.tv_name_person_detail)
        email = findViewById(R.id.tv_email_person_detail)
        jurusan = findViewById(R.id.tv_jurusan_person_detail)
        semester = findViewById(R.id.tv_semester_person_detail)
    }
    fun getData(){

        val data = intent.getSerializableExtra("person" ) as Person
        Glide.with(this).load(data.profileUrl).placeholder(R.drawable.ic_launcher_background).into(profile)
        name.text = data.name
        email.text = data.email
        jurusan.text = data.jurusan
        semester.text = data.semester.toString()

    }
}