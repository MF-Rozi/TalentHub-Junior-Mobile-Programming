package com.mfrozi.juniormobileprogrammertask4.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mfrozi.juniormobileprogrammertask4.PersonDetail
import com.mfrozi.juniormobileprogrammertask4.R
import com.mfrozi.juniormobileprogrammertask4.databinding.PersonListItemBinding
import com.mfrozi.juniormobileprogrammertask4.models.Person

class PersonListAdapter : RecyclerView.Adapter<PersonListAdapter.PersonListViewHolder>() {

    private var listPersons = ArrayList<Person>()
    fun addPersonToList(list: List<Person>){
        this.listPersons.clear()
        this.listPersons.addAll(list)
    }

    inner class PersonListViewHolder(val binding: PersonListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.tvNamePeopleListItem.text = listPersons[position].name
            binding.tvEmailPeopleListItem.text = listPersons[position].email
            binding.tvJurusanPeopleListItem.text = listPersons[position].jurusan
            binding.tvSemesterPeopleListItem.text = listPersons[position].semester.toString()
            Glide
                .with(binding.root.context)
                .load(listPersons[position].profileUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivProfilPicturePeopleListItem)
            binding.layoutPersonListItem.setOnClickListener{
                val i = Intent(itemView.context, PersonDetail::class.java)
                i.putExtra("person",listPersons[position])
                itemView.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonListAdapter.PersonListViewHolder {
        return  PersonListViewHolder(PersonListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PersonListAdapter.PersonListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return listPersons.size
    }
}