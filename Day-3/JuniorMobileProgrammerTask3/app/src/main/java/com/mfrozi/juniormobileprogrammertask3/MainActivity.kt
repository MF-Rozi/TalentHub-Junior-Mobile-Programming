package com.mfrozi.juniormobileprogrammertask3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mfrozi.juniormobileprogrammertask3.adapters.PersonListAdapter
import com.mfrozi.juniormobileprogrammertask3.datasource.PersonData
import com.mfrozi.juniormobileprogrammertask3.models.Person

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRV()
    }

    private fun setRV(){
        val data = PersonData.listPerson
        val rvPersonAdapter = PersonListAdapter()

        rv = findViewById(R.id.rv_activity_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = rvPersonAdapter

        rvPersonAdapter.addPersonToList(data)

        rvPersonAdapter.onItemClick = {person ->
            val i = Intent(this,PersonDetail::class.java)
            i.putExtra("person",person)
            startActivity(i)
        }

    }
}