package com.mfrozi.juniormobileprogrammertask3.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.mfrozi.juniormobileprogrammertask3.R
import com.mfrozi.juniormobileprogrammertask3.models.Person
import javax.inject.Inject

class PersonListAdapter @Inject constructor() : RecyclerView.Adapter<PersonListAdapter.PersonListViewHolder>() {
    private var listPerson = ArrayList<Person>()
    var onItemClick: ((Person) -> Unit)? = null
    fun addPersonToList(list: List<Person>){
        this.listPerson.clear()
        this.listPerson.addAll(list)
    }
 inner class PersonListViewHolder(view: View): RecyclerView.ViewHolder(view){
    val profileImage : ImageView
    val name : TextView
    val email : TextView
    val jurusan : TextView
    val semester : TextView
     init {
         profileImage = view.findViewById(R.id.iv_profil_picture_people_list_item)
         name = view.findViewById(R.id.tv_name_people_list_item)
         email = view.findViewById(R.id.tv_email_people_list_item)
         jurusan = view.findViewById(R.id.tv_jurusan_people_list_item)
         semester = view.findViewById(R.id.tv_semester_people_list_item)

         //inject On Click Listener
         view.setOnClickListener {
             onItemClick?.invoke(listPerson[adapterPosition])
    }
 }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_list_item,parent,false)
        return PersonListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: PersonListViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listPerson[position].profileUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.profileImage)
        holder.name.text = listPerson[position].name
        holder.email.text = listPerson[position].email
        holder.jurusan.text = listPerson[position].jurusan
        holder.semester.text = listPerson[position].semester.toString()
    }
}