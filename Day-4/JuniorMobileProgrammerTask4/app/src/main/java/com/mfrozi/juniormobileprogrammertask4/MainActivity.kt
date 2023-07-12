package com.mfrozi.juniormobileprogrammertask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mfrozi.juniormobileprogrammertask4.adapters.PersonTabLayoutAdapter
import com.mfrozi.juniormobileprogrammertask4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTabLayout()
    }
    private  fun setTabLayout(){
        val vpAdapter = PersonTabLayoutAdapter(supportFragmentManager)
        binding.vpMainActivity.adapter = vpAdapter

        binding.tlMainActivity.setupWithViewPager(binding.vpMainActivity)
    }
}