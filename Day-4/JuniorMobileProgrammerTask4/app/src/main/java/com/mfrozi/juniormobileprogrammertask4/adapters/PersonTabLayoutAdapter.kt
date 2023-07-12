package com.mfrozi.juniormobileprogrammertask4.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mfrozi.juniormobileprogrammertask4.PesertaAFragment
import com.mfrozi.juniormobileprogrammertask4.PesertaBFragment

class PersonTabLayoutAdapter (fm : FragmentManager  ) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val listOfFragment = arrayListOf(PesertaAFragment(),PesertaBFragment())
    override fun getCount(): Int {
        return listOfFragment.size
    }

    override fun getItem(position: Int): Fragment {
       return when (position){
           0-> listOfFragment[position]
           else -> listOfFragment[position]
       }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "Peserta A"
            else -> "Peserta B"
        }
    }
}