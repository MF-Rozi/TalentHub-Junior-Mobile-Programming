package com.mfrozi.juniormobileprogrammertask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfrozi.juniormobileprogrammertask4.adapters.PersonListAdapter
import com.mfrozi.juniormobileprogrammertask4.databinding.FragmentPesertaABinding
import com.mfrozi.juniormobileprogrammertask4.databinding.FragmentPesertaBBinding
import com.mfrozi.juniormobileprogrammertask4.datasources.PersonDataA

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PesertaAFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PesertaAFragment : Fragment() {
    private var _binding : FragmentPesertaABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPesertaABinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()

    }
    fun setupRV(){
        val data = PersonDataA.listPerson
        val rvPersonAdapter = PersonListAdapter()
        binding.rvFragmentA.layoutManager = LinearLayoutManager(context)
        binding.rvFragmentA.adapter = rvPersonAdapter

        rvPersonAdapter.addPersonToList(data)
    }


}