package com.example.fragmentdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdemo.databinding.FragmentOutputBinding


class OutputFragment : Fragment() {

    lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        val city = activity?.intent?.getStringExtra("city")?: "Keine Stadt vorhanden"
        binding.tvCity.text = city

        binding.btnWeb.setOnClickListener {
            // Aufruf der Website durch impliziten Intent. Kein direktes Ziel
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.$city.de")
            startActivity(intent)
        }
        return binding.root
    }


}